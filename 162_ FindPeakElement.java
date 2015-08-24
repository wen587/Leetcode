/*
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ¡Ù num[i+1], find a peak element and 
 * return its index.
 * The array may contain multiple peaks, in that case return the index to any 
 * one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -¡Þ.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function 
 * should return the index number 2.
 * click to show spoilers.
 * Note:
 * Your solution should be in logarithmic complexity.
 */




//O(logn)

public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0; 
        int r = nums.length - 1;
        int res = 0;
        while( l < r) {
            int mid = (l + r) / 2;
            if(nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}