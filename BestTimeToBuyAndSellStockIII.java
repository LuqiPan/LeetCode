/*
 *Say you have an array for which the ith element is the price of a given stock on day i.
 *
 *Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 *Note:
 *You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int min = prices[0];
        int[] maxProfitBefore = new int[len];
        int profit = 0;
        for (int i = 0 ; i < len ; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
            maxProfitBefore[i] = profit;
        }
        
        int max = prices[len-1];
        profit = 0;
        int result = 0;
        for (int i = len - 1; i >= 0 ; i--) {
            max = Math.max(max, prices[i]);
            profit = Math.max(profit, max - prices[i]);
            result = Math.max(result, profit+maxProfitBefore[i]);
        }
        
        return result;
    }
}
