/*
 * Given an array of integers, every element appears three times except for 
 * one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement 
 * it without using extra memory?
 */

public class Solution {
    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for(int i=0; i<A.length; i++) {
            if(!map.containsKey(A[i])) map.put(A[i], 0);
            else map.put(A[i], map.get(A[i]) + 1);
        }
        for(int i=0; i<A.length; i++) {
            if(map.get(A[i]) == 0) res = A[i];
        }
        return res;
    }
}


//bit manipulation
public class Solution {
    public int singleNumber(int[] A) {
        int res = 0;
        for(int i=0; i<32; i++) {
            int mask = 1 << i;
            int c = 0;
            for(int j=0; j<A.length; j++) {
                int count = 0;
                int val = A[j] & mask;
                if(val>0 || val<0) c++;
            }
            if(c%3 > 0) res = res | mask;
        }
        return res;
    }
}