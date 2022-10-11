class Solution {
    HashSet<Integer> forbiddenSet = new HashSet<>();
    int bound;
    int[][] memo;
    
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int maxForbidden = -1;
        for (int f: forbidden) {
            forbiddenSet.add(f);
            maxForbidden = Math.max(maxForbidden, f);
        }
        bound = Math.max(maxForbidden + a + b, x + b);
        
        memo = new int[bound + 1][2]; // 0 for forward; 1 for backward
        
        for (int i = 0; i < bound + 1; i++) {
            for (int j = 0; j < 2; j++) {
                memo[i][j] = -1;
            }
        }
        
        int res = dp(a, b, x, 0, 0);
        
        return res > 6000 ? -1 : res;
    }
    
    public int dp(int a, int b, int x, int curr, int direction) {
        
        if (curr > bound || curr < 0 || forbiddenSet.contains(curr)) return 7000;
        
        if (curr == x) return 0;
        
        if (memo[curr][direction] == -1) {
            
            
            memo[curr][direction] = 1 + dp(a, b, x, curr + a, 0);
            
            if (direction == 0) { //forward
                memo[curr][direction] = Math.min(memo[curr][direction], 1 + dp(a, b, x, curr - b, 1));
            }
        }
     
        return memo[curr][direction];
        
    }
}