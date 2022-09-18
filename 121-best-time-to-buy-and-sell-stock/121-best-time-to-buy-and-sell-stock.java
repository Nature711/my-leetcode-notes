class Solution {
      public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;
        int left = 0;
        int right = 1;
        int max = 0;
        while (right < n) {
            if (prices[left] > prices[right]) {
                left = right;
                right++;
            } else {
                max = Math.max(prices[right] - prices[left], max);
                right++;
            }
        }
        return max;
    }
}