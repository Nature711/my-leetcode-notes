class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, sell = 0, totalProfit = 0, n = prices.length;
        while (buy < n && sell < n) {
            //System.out.println("buy " + buy + " sell " + sell);
            while (buy + 1 < n && prices[buy + 1] < prices[buy]) buy++;
            sell = buy + 1;
            while (sell + 1 < n && prices[sell + 1] > prices[sell]) sell++;
            if (sell < n && buy < n) totalProfit += prices[sell] - prices[buy];
            buy = sell + 1;
        }
        return totalProfit;
    }
}