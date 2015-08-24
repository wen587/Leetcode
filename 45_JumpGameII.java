/*
 * Given an array of non-negative integers, you are 
 * initially positioned at the first index of the array.
 * Each element in the array represents your maximum 
 * jump length at that position.
 * Your goal is to reach the last index in the minimum 
 * number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index 
 * is 2. (Jump 1 step from index 
 * 0 to 1, then 3 steps to the last index.)
 */
//
public class Solution {
    public int jump(int[] nums) {
        int maxSofar = 0;
        int maxGlobal = 0;
        int cnt = 0;
        for(int i=0; i<nums.length - 1; i++) {
            maxGlobal = Math.max(maxGlobal, i + nums[i]);
            if(i == maxSofar) {
                cnt++;
                maxSofar = maxGlobal;
            }
        }
        return maxSofar >= nums.length - 1 ? cnt : -1;
    }
}

//
public class Solution {
    public int jump(int[] nums) {
        if(nums.length < 1) return 0;
        int maxSofar = 0;
        int max = 0;
        int cnt = 0;
        for(int i=0; i<=maxSofar && i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if(i == maxSofar) {
                cnt++;
                maxSofar = max;
            }
        }
        return maxSofar >= nums.length - 1 ? cnt : -1;
    }
}