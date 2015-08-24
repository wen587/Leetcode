/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
* (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
* Find the minimum element.
* You may assume no duplicate exists in the array.
*/
// What if duplicates are allowed?

// Would this affect the run-time complexity? How and why?
//O(logn)
public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int res = 0;
        int r = nums.length - 1;
        while(l <= r) {
            while(r > 0 && nums[r] == nums[r - 1]) r--;
            int mid = (l + r) / 2;
            if(nums[mid] >= nums[r]) {
                res = l;
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[res];
    }
}