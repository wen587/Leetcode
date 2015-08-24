// Given a sorted array of integers, find the starting and ending position of a given target value.

// Your algorithm's runtime complexity must be in the order of O(log n).

// If the target is not found in the array, return [-1, -1].

// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int pos1 = firstNum(nums, target);
        if(pos1 == nums.length || nums[pos1] != target) return new int[] {-1, -1};
        int pos2 = firstNum(nums, target+1);
        return new int[]{pos1, pos2 - 1};
    }
    private int firstNum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] < target) {
                l = mid + 1;
            } else r = mid - 1;
        }
        return l;
    }

}