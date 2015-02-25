/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 */

//巧妙
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        m--;
        n--;
        while(n >= 0) {
            if(m >= 0) A[m + n + 1] = (A[m] > B[n]) ? A[m--] : B[n--];
            else A[n] = B[n--];
        }
    }
}

//same
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int idx = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[idx--] = A[i--];
            } else {
                A[idx--] = B[j--];
            }
        }

        if (i == -1) {
            while (j >= 0) {
                A[j] = B[j];
                j--;
            }
        }
    }
}