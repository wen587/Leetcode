/*
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */


public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0)
            return A.length;
        int count = 1;
        int index = 1;
        for (int i = 1; i < A.length; i++) {
            count = A[i] == A[i - 1] ? count + 1 : 1;
            if (count <= 2)
                A[index++] = A[i];
        }
        return index;
    }
}
//For K times
int removeDuplicates(int A[], int n, int k) {

            if (n <= k) return n;

            int i = 1, j = 1;
            int cnt = 1;
            while (j < n) {
                if (A[j] != A[j-1]) {
                    cnt = 1;
                    A[i++] = A[j];
                }
                else {
                    if (cnt < k) {
                        A[i++] = A[j];
                        cnt++;
                    }
                }
                ++j;
            }
            return i;
}