class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, sell = 0, n = prices.length, maxProfit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] < prices[buy]) {
                buy = i;
                sell = buy + 1;
            } else if (prices[i] > prices[sell]) {
                sell = i;
            }
            //System.out.println("buy " + buy + " sell " + sell);
            if (sell == n) break;
            maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
        }
        
        return maxProfit;
    }
}