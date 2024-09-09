class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minimum = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - minimum;
            profit = Math.max(profit, diff);
            minimum = Math.min(minimum, prices[i]);
        }
        return profit;
    }
}
