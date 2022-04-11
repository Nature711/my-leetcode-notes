### Perfect Squares

- [Leetcode -- Perfect Squares (Medium)](https://leetcode.com/problems/perfect-squares/）

## Top-down recursion without memo (Time limit exceeded)
- similar idea to coin change
- perfect square numbers ~~ available denominations
- to find the min no of perfect squares that add up to n ~~ to make change for n using available denominations
- most naive approach: using all 1s (initialization)
- goal is to make use of avaiable denomiations to optimize
- at each step I can either stay with current choice, or use one more perfect square number to "make change" for the current amount
- after making change the remaining amount is the input to subproblem
- solution to current step is the optimized result among all attempts 
```
    public int numSquares(int n) {
        int ans = n;
        for (int i = 1; i < n; i++) {
            int square = i * i;
            if (square > n || square < 0) break;
            ans = Math.min(ans, 1 + numSquares(n - square)); 
        }
        return ans;
    }
```

## Top down recursion with memo (Accepted, faster than 20%)
```
    HashMap<Integer, Integer> memo = new HashMap<>();
    
    public int numSquares(int n) {
        //top-down recursion -- time limit exceeded
        int ans = n;
        for (int i = 1; i < n; i++) {
            int square = i * i;
            if (square > n || square < 0) break;
            int rem = n - square;
            int sub = memo.containsKey(rem) ? memo.get(rem) : numSquares(rem); //if subproblem is already in memo then use it, otherwise compute and store
            ans = Math.min(ans, 1 + sub);
        }
        memo.put(n, ans); //store a newly found solution to subproblem
        return ans;
    }
```

## Bottom up DP -- Backward (Accepted, faster than 96%)

```
   public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = i;
        
        for (int target = 2; target <= n; target++) {
            for (int i = 1; i < target; i++) {
                int rem = target - i * i; //each dp[curr] asks the previous dp[rem] where rem is curr substracting away some perfect sqaure
                if (rem < 0) break;
                dp[target] = Math.min(dp[target], 1 + dp[rem]);
            }
        }
       
        return dp[n];
    }
```

## Bottom up DP -- Forward (Accepted, faster than 70%)
```
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = i;
        
        for (int target = 0; target <= n; target++) {
            for (int i = 1; i <= n; i++) {
                int next = target + i * i; //each dp[curr] contributes to the possible optimization of dp[curr + (some power)] by using one more perfect square
                if (next > n || next < 0) break;
                dp[next] = Math.min(dp[next], dp[target] + 1); 
            }
        }
        return dp[n];
    }
```

## BFS (Accepted, faster than 5%)
```
  public int numSquares(int n) {
        if (isPerfectSquare(n)) return 1;
        List<Integer> candidates = findPerfectSquares(n);
        
        Queue<int[]> queue = new LinkedList<>();
        for (int candidate: candidates) {
            int[] node = {candidate, candidate};
            queue.offer(node);
        }
    
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s = 0; s < size; s++){
                int[] curr = queue.poll();
                if (curr[1] == n) return level + 1;

                List<Integer> choices = findPerfectSquares(curr[0]);
                for(int choice : choices) {
                    int acc = curr[1] + choice;
                    if (acc == n) return level + 2;
                    if (acc > n) continue;
                    queue.offer(new int[]{choice, acc});
                }
            }
            level++;
        }
        return level;
    }
    
    //returns all perfect square numbers that are less than n
    public List<Integer> findPerfectSquares(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            if (isPerfectSquare(i)) res.add(i);
        }
        return res;
    }

    //check if n is a perfect square number
    public boolean isPerfectSquare(int n) {
        double number = Math.sqrt(n);
        return Math.ceil(number) == Math.floor(number); 
    }
```
