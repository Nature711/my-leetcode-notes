class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] free = new int[n], hold = new int[n];
        hold[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], free[i - 1] - prices[i]);
            free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i]);
        }
        return Math.max(free[n - 1], hold[n - 1]);
    }
}