## Backtracking (trying every possibility) -- works but TLE
```
    int[] globalNums;
    long globalMax;
    public int maximumProduct(int[] nums, int k) {
        globalNums = nums;
        long prod = 1;
        for (int i = 0; i < nums.length; i++) {
            if (globalNums[i] == 0) {
                if (k == 0) return 0;
                else {
                    globalNums[i]++;
                    k--;
                }
            } 
            prod *= globalNums[i];
        }
        helper(prod, k);
        return (int) (globalMax % (Math.pow(10, 9) + 7));
    }
    
    public void helper(long currProduct, int k) {
        if (k == 0) {
            globalMax = Math.max(currProduct, globalMax);
            return;
        }
        
        for (int i = 0; i < globalNums.length; i++) {
            int oldNum = globalNums[i];
            globalNums[i]++;    
            helper((currProduct / oldNum) * globalNums[i], k - 1);
            globalNums[i]--;
        }
        
    }
```


## Greedy

Increasing a number by 1 is equivalent to add the product of the other numbers to the result. 
e.g., 
```
product1 = n1 * n2 * n3 * n4
product2= (n1 + 1) * n2 * n3 * n4 = product1 + (n2 + n3 + n4)
```
In order to maximize the product, each time we should make the product of the other numbers as large as possible, so we greedily increase the the minimal number in each round.

Code
```
 public int maximumProduct(int[] nums, int k) {
           
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //min heap by default
        
        for (int num: nums) pq.add(num);
        
        while (k-- > 0) pq.add(pq.poll() + 1);
        
        long currProd = 1;
        
        while (!pq.isEmpty()) currProd = (long) ((pq.poll() * currProd) % (Math.pow(10, 9) + 7));
        
        return (int) (currProd % (Math.pow(10, 9) + 7));
    }
```
