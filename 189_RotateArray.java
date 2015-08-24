/*
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,
 * 5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are 
 * at least 3 different ways to solve this problem.
 */


public class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int[] temp = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            temp[i] = nums[i];
        }
        for(int i=0; i<nums.length - k; i++) {
                nums[i + k] = temp[i];
        }
        for(int i=0; i<k; i++) {
            nums[i] = temp[nums.length - k + i];
        }
    }
}
//O(k) space
public class Solution {
    p public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = nums[nums.length - k + i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] = i >= k ? nums[i - k] : tmp[i];
        }
    }
}
