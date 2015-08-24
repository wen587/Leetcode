// Given a list of non negative integers, arrange them such that they form the largest number.

// For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

// Note: The result may be very large, so you need to return a string instead of an integer.


public class Solution {
    public String largestNumber(int[] nums) {
        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer l1, Integer l2) {
                String s1 = "" + l1 + l2;
                String s2 = "" + l2 + l1;
                return -s1.compareTo(s2);
            }
        };
        Integer[] arr = new Integer[nums.length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, comp);
        boolean leadingZero = true;
        String res = "";
        for(int num : arr) {
            if(leadingZero) {
                if(num == 0) return "0";
                else {
                    res = res + num;
                    leadingZero = false;
                }
            } else {
                res += num;
            }
        }
        return res;
    }
}