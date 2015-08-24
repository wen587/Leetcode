/*
 * Given an array of size n, find the majority element. The majority 
 * element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority 
 * element always exist in the array. 
 */
//hashmap
public class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) {
                
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if(map.get(num) > nums.length / 2) res = num;;
        }
        return res;
    }
}

//666
public class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int maj = 0;
        for(int i=0; i<nums.length; i++) {
            if(cnt == 0) {
                maj = nums[i];
                cnt ++;
            } else if(maj == nums[i]) { 
                cnt ++;
            } else cnt --;
        }
        return maj;
    }
}