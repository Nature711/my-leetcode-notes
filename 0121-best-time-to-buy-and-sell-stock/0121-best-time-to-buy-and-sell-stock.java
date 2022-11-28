class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, sell = 0, maxProfit = 0;
        
        while (sell < prices.length) {
            if (prices[buy] > prices[sell]) buy = sell;
            else maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            sell++;
        }
        
        return maxProfit;
    }
}