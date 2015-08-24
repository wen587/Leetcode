// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

// Hint:

// How many majority elements could it possibly have?


public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int candidate1 = 0;
        int candidate2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int n : nums) {
            if(candidate1 == n) cnt1++;
            else if(candidate2 == n) cnt2++;
            else if(cnt1 == 0) {
                candidate1 = n;
                cnt1++;
            } else if(cnt2 == 0) {
                candidate2 = n;
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = cnt2 = 0;
        for(int n : nums) {
            if(n == candidate1) cnt1++;
            else if(n == candidate2) cnt2++;
        }
        if(cnt1 > nums.length / 3) res.add(candidate1);
        if(cnt2 > nums.length / 3) res.add(candidate2);
        return res;
    }
}

//O(k*n) time O(k) space
private List<Integer> solver(int[] nums, int k) {
        List<Integer> ret = new LinkedList<Integer>();
        int[] buffer = new int[k-1];
        int[] count = new int[k-1];
        Arrays.fill(count, 0);
        Arrays.fill(buffer, Integer.MIN_VALUE);
        for(int i=0;i<nums.length;i++) {
            boolean find = false;
            for(int j=0;j<k-1;j++) {
                if(nums[i]==buffer[j]) {
                    count[j]++;
                    find=true;
                    break;
                } 
                else if(count[j]==0) {
                    buffer[j]=nums[i];
                    count[j]=1;
                    find=true;
                    break;
                }
            }
            if(!find) {
                for(int j=0;j<k-1;j++) {
                    count[j]--;
                }
            }
        }
        Arrays.fill(count, 0);
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<k-1;j++) {
                if(nums[i]==buffer[j]) {
                    count[j]++;
                    if(count[j]>(nums.length/k)) {
                        ret.add(nums[i]);
                        count[j]=Integer.MIN_VALUE;
                    }
                    break;
                }
            }
        }
        return ret;
    }