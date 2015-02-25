/*
 * Given an array of size n, find the majority element. The majority 
 * element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority 
 * element always exist in the array. 
 */

public class Solution {
    public int majorityElement(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for(int i=0; i<num.length; i++){
            if(!map.containsKey(num[i])) map.put(num[i], 1);
            else map.put(num[i], map.get(num[i]) + 1);
            
            if(map.get(num[i]) > num.length/2) res = num[i];
        }
        return res;
    }
}

//count bits need to see
// We can iterate over the bits of all numbers and
// for every position find out if ones outnumber the 
// zeros (among all numbers). If this is the case, the 
// corresponding bit of the ret variable (which holds the result
// ) is set. We essentially "construct" the number we look for.
public int majorityElement(int[] num) {

    int ret = 0;

    for (int i = 0; i < 32; i++) {

        int ones = 0, zeros = 0;

        for (int j = 0; j < num.length; j++) {
            if ((num[j] & (1L << i)) != 0) {
                ++ones;
            }
            else
                ++zeros;
        }

        if (ones > zeros)
            ret |= (1L << i);
    }

    return ret;
}