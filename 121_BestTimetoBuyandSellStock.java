/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one 
 * share of the stock), design an algorithm to find the maximum profit.
 */

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


public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length<=1) {
            return 0;
        }
         
        Integer[] mins = new Integer[prices.length]; // first n days
        Integer[] maxs = new Integer[prices.length]; // last n days
        mins[0] = prices[0];
        maxs[prices.length-1] = prices[prices.length-1];
         
        // fill max prices, from right to left
        for (int i=prices.length-2; i>=0; i--) {
            if (prices[i]>maxs[i+1])
                maxs[i] = prices[i];
            else
                maxs[i] = maxs[i+1];
        }
         
        // fill min prices, and calculate the biggest profit, from left to right
        int biggestProfit = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i]<mins[i-1])
                mins[i] = prices[i];
            else
                mins[i] = mins[i-1];
             
            int profit = maxs[i] - mins[i];
            if (profit>biggestProfit)
                biggestProfit = profit;
        }
         
        return biggestProfit;
    }
}