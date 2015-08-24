// Find the contiguous subarray within an array (containing at least one number) which has the largest product.

// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.

//space efficient dp
public class Solution {
     public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}

//normal O(n) space dp
public class Solution {
    public int maxProduct(int[] nums) {
        int[] dpPos = new int[nums.length];
        int[] dpNeg = new int[nums.length];
        dpPos[0] = dpNeg[0] = nums[0];
        int res = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > 0) {
                dpPos[i] = Math.max(nums[i] * dpPos[i - 1], nums[i]);
                dpNeg[i] = nums[i] * dpNeg[i - 1];
                res = Math.max(res, dpPos[i]);
            }
            else {
                dpPos[i] = nums[i] * dpNeg[i - 1];
                dpNeg[i] = Math.min(nums[i] * dpPos[i - 1], nums[i]);
                res = Math.max(res, dpPos[i]);
            }
        }
        return res;
    }
}