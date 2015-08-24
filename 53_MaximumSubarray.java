

/* Find the contiguous subarray within an array (containing at least one 
 * number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */ 

//divide and conquer 66666
public class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    public int helper(int[] nums, int left, int right) {
        if(left == right) return nums[left];
        int mid = (left + right) / 2;
        int l = helper(nums, left, mid);
        int r = helper(nums, mid + 1, right);
        int leftMax = nums[mid];
        int rightMax = nums[mid + 1];
        int temp = 0;
        for(int i=mid; i>=left; i--) {
            temp += nums[i];
            leftMax = Math.max(leftMax, temp);
        }
        temp = 0;
        for(int i=mid + 1; i <= right; i++) {
            temp += nums[i];
            rightMax = Math.max(rightMax, temp);
        }
        return Math.max(Math.max(l, r), leftMax + rightMax);
    }
}


//my dp
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i=1; i<dp.length; i++) {
            dp[i] = dp[i - 1] > 0 ? nums[i] + dp[i - 1] : nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

