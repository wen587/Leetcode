// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

//O(n) and O(1) space dp
public class Solution {
    public int rob(int[] nums) {
        if(nums.length < 1) return 0;
        int prevNo = 0;
        int prevYes = 0;
        for(int i=0; i<nums.length; i++) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = temp + nums[i];
        }
        return Math.max(prevNo, prevYes);

    }
    // public int rob(int[] nums) {
    //     if(nums.length < 1) return 0;
    //     int[] dp = new int[nums.length];
    //     dp[0] = nums[0];
    //     for(int i=1; i<nums.length; i++) {
    //         if(i == 1) {
    //             dp[i] = Math.max(dp[0], nums[1]);
    //             continue;
    //         }
    //         dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
    //     }
    //     return dp[nums.length - 1];
    // }
}