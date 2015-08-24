// Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

// For example, given the array [2,3,1,2,4,3] and s = 7,
// the subarray [4,3] has the minimal length under the problem constraint.

// click to show more practice.

// More practice:
// If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).



//My simple O(n) slt, two pointer
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int j = 0;
        int sum = 0;
        int res = nums.length + 1;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            while(sum >= s) {
                res = Math.min(res, i - j + 1);
                sum -= nums[j++];
            }
        }
        return res > nums.length ? 0 : res;
    }
}
//O(n)
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length < 1) return 0;
        int sum = nums[0];
        int right = 0;
        int left = 0;
        int min = nums.length + 1;
        while(right < nums.length && left <= right) {
            if(sum < s) {
                right++;
                if(right < nums.length)
                    sum += nums[right];
            } else {
                min = Math.min(right - left + 1, min);
                sum -= nums[left];
                left++;
            }
        }
        if(min == nums.length + 1) return 0;
        return min;
    }
}

//O(nlgn)




//weak
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int j=0; j<nums.length; j++) {
            int cnt=0;
            int tmp = s;
            for(int i=j; i<nums.length; i++) {
                tmp = tmp - nums[i];
                if(tmp > 0) cnt++;
                else {
                    cnt++;
                    res = Math.min(cnt, res);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    
}