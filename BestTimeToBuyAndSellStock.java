/*
 *Say you have an array for which the ith element is the price of a given stock on day i.
 *
 *If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1 ; i < prices.length ; i++) {
            if (prices[i] >= min) {
                int curProfit = prices[i] - min;
                maxProfit = Math.max(curProfit, maxProfit);
            } else {
                min = prices[i];
            }
        }
        return maxProfit;
    }
}

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for (int i = 0 ; i < len ; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}
