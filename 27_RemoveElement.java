/*
 * Given an array and a value, remove all instances of that value in place and 
 * return the new length.
 * The order of elements can be changed. It doesn't matter what you leave 
 * beyond the new length.
 */
//my solution, but not accepted
public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A.length<1) return 0;
        int res = A.length;
        for(int i=0; i<A.length; i++) {
            if(A[i] == elem) res--;
        }
        return res;
    }
} 

//accepted but not work with {1} , 1
public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A.length<1) return 0;
        int count = 0;
        for(int i=0; i<A.length; i++) {
            if(A[i] != elem) {
                A[count] = A[i];
                count ++;
            }
        }
        return count;
    }
}