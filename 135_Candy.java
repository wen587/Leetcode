/*
 * There are N children standing in a line. Each child is assigned a rating 
 * value.
 * You are giving candies to these children subjected to the following 
 * requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */


//
public class Solution {
    public int candy(int[] ratings) {
        if(ratings.length < 1) return 0;
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        left[0] = 1;
        right[ratings.length - 1] = 1;
        for(int i=1; i<left.length; i++) {
            left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 1;
        }
        for(int i = right.length - 2; i>=0; i--) {
            right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1 : 1;
        }
        int sum = 0;
        for(int i=0; i<ratings.length; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}

//AC Answer
public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            candies[i] = (i > 0 && ratings[i] > ratings[i - 1]) ? 
                candies[i - 1] + 1 : 1;
        } 
        int result = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
            result += candies[i];
        }
        return result;
    }


or 
public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        if (ratings.length == 1)
            return 1;
 
        int[] candies = new int[ratings.length];
        candies[0] = 1;
 
        // forward
        for (int i = 1; i < ratings.length; i++) {
            // rating: asc
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
            else
                candies[i] = 1;
        }
        // backward
        for (int i = ratings.length - 2; i >= 0; i--) {
            // rating: desc && candy: asc
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1])
                candies[i] = candies[i + 1] + 1;
        }
 
        int total = 0;
        for (int i = 0; i < ratings.length; i++)
            total += candies[i];
 
        return total;
    }
}