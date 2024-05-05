class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, buy = Integer.MAX_VALUE, sell = Integer.MIN_VALUE;
        for (int price: prices) {
                if (price < buy) {
                        buy = price;
                        sell = Integer.MIN_VALUE;
                } else {
                        sell = price;
                        maxProfit = Math.max(maxProfit, sell - buy);
                }
        }
        return maxProfit;

    }
}