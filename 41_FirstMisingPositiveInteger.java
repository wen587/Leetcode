/*
 * Given an unsorted integer array, find the first missing positive integer.
 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 */

public class Solution {
    public int firstMissingPositive(int[] A) {
        int i=0;
        while(i < A.length) {
            if(A[i]>0  && A[i] != i + 1   && A[i] < A.length
            && A[A[i] - 1] != A[i]) {
                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            } else i++;
        }
        for(i=0; i<A.length; i++) {
            if(A[i] != i+ 1) return i + 1;
        }
        return A.length + 1;
    }
}
