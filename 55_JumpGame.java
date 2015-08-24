/*
 * Given an array of non-negative integers, you are initially 
 * positioned at the first index of the array.
 * Each element in the array represents your maximum 
 * jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */

//greedy1

public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0; i<=max ; i++) {
            max = Math.max(nums[i] + i, max);
            if(max >= nums.length - 1) return true;
        }
        return false;
    }
}

//greedy2
public class Solution {
    public boolean canJump(int[] nums) {
        // int n = nums.length - 1;
        int len = 0;
        for(int i=0; i<nums.length; i++) {
            
            if(i>len) return false;
            len = Math.max(i + nums[i], len);
        }
        return true;
    }
}
