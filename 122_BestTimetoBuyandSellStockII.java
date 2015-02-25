/*
 * Say you have an array for which the ith element is the price of a given 
 * stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many 
 * transactions as you like (ie, buy one and sell one share of the stock 
 * multiple times). However, you may not engage in multiple transactions at 
 * the same time (ie, you must sell the stock before you buy again).
 */

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int profit = 0;
        for(int i=0; i<prices.length-1; i++) {
            if(prices[i]< prices[i+1]) {
                profit += prices[i+1] - prices[i];
            } 
        }
        return profit;
    }
    
}



// if not greedy answer 
// public int maxProfit(int[] prices) {
//     int profit = 0, i = 0;
//     while (i < prices.length) {
//         // find next local minimum
//         while (i < prices.length-1 && prices[i+1] <= prices[i]) i++;
//         int min = prices[i++]; // need increment to avoid infinite loop for "[1]"
//         // find next local maximum
//         while (i < prices.length-1 && prices[i+1] >= prices[i]) i++;
//         profit += i < prices.length ? prices[i++] - min : 0;
//     }
//     return profit;
// }