/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
* (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
* Find the minimum element.
* You may assume no duplicate exists in the array.
*/
//O(logn)
public class Solution {
    public int findMin(int[] num) {
        int min = 0;
        int max = num.length -1;
        while(num[min] > num[max]) {
            int mid = (min + max)/2;
            if(num[min] > num[mid]) max = mid;
            else if(num[min] < num[mid]) min = mid + 1;
            else return num[max];
        }
        return num[min];
    }
}


public class FindMinimumInRotatedSortedArray {
    
    public int findMin(int[] num) {
        int start = 0;
        int end = num.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] < num[end]) 
                end = mid;
            else
                start = mid + 1;
        }
        return num[start];
    } 
}

//O(n)
public class Solution {
    public int findMin(int[] num) {
        for(int i=1; i<num.length; i++) {
            if(num[i] < num[i-1]) return num[i];
        }
        return num[0];
    }
}