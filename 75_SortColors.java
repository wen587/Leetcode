/*
 * Given an array with n objects colored red, white or blue, sort them so that 
 * objects of the same color are adjacent, with the colors in the order red, 
 * white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, 
 * white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting 
 * sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then 
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 */

public class Solution {
    public void sortColors(int[] A) {
    	int[] B = new int[A.length];
    	for(int i=0; i<A.length; i++) {
    		B[i] = A[i];
    	}
        int j = 0;
        for(int i=0; i<B.length; i++) {
            if(B[i]==0) {
                A[j] = B[i];
                j++;
            }
        }
        for(int i=0; i<B.length; i++) {
            if(B[i]==1) {
                A[j] = B[i];
                j++;
            }
        }
        for(int i=0; i<B.length; i++) {
            if(B[i]==2) {
                A[j] = B[i];
                j++;
            }
        }
    }
}

//same idea
public void sortColors(int[] A) {
        int zeroes = 0;
        int ones = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0)
                zeroes++;
            else if (A[i] == 1)
                ones++;
        }
        for (int i = 0; i < A.length; i++) {
            if (i < zeroes) 
                A[i] = 0;
            else if (i < zeroes + ones)
                A[i] = 1;
            else 
                A[i] = 2;
        }
 }

 //use two pointer
 public class SortColors {

    public void sortColors(int[] A) {
        int left = 0;
        int right = A.length - 1;
        for (int i = 0; i <= right; i++) {
            if (A[i] == 0) 
                swap(A, i, left++);
            else if (A[i] == 2)
                swap(A, i--, right--);
        }
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

//dont understand
public void sortColors(int[] A) {
        int[] cnt = new int[3];
        for(int i = 0; i < A.length; i++) 
            cnt[A[i]]++;
        for(int i = 0, index = 0; i < 3; i++)
            for(int j = 0; j < cnt[i]; j++) 
                A[index++] = i;
    }

//one pass is what?
 public void sortColors(int[] A) {


    int i=-1, j=-1, k=-1;

    for(int p = 0; p < A.length; p++)
    {
        if(A[p] == 0)
        {
            A[++k]=2;
            A[++j]=1;
            A[++i]=0;
        }
        else if (A[p] == 1)
        {
            A[++k]=2;
            A[++j]=1;

        }
        else if (A[p] == 2)
        {
            A[++k]=2;
        }
    }

}