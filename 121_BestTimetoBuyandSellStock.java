/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one 
 * share of the stock), design an algorithm to find the maximum profit.
 */

//my dp
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 1) return 0;
        int res = 0;
        int rightMax = prices[prices.length - 1];
        for(int i=prices.length - 1; i>=0; i--) {
            rightMax = Math.max(rightMax, prices[i]);
            res = Math.max(res, rightMax - prices[i]);
        }
        return res;
    }
}

//
public class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if(N<=1) return 0;
        int min = prices[0];
        int profit = 0;
        for(int i=0; i<N; i++) {
            if(min>prices[i]) {
                min = prices[i];
            } else {
                profit = Math.max(profit, prices[i]-min);
            }
        }
        return profit;
    }
}

