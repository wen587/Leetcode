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
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = m + n - 1;
        m--;
        n--;
        while(m >= 0 && n >= 0) {
            nums1[cur--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        if(m < 0) {
            while(n >= 0) {
                nums1[cur--] = nums2[n--];
            }
        }
    }
}
}