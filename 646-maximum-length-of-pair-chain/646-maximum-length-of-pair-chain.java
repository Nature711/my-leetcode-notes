class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> p1[0] - p2[0]);
        
        int[] dp = new int[pairs.length];
        
        int res = 0;
        
        for (int i = 0; i < pairs.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(dp[i], res);
        }
        
        return res;
    }
}