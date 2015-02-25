/*
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ¡Ù num[i+1], find a peak element and 
 * return its index.
 * The array may contain multiple peaks, in that case return the index to any 
 * one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -¡Þ.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function 
 * should return the index number 2.
 * click to show spoilers.
 * Note:
 * Your solution should be in logarithmic complexity.
 */
//O(n)
public class Solution {
    public int findPeakElement(int[] num) {
        if(num.length == 1) return 0;
        int[] copy = new int[num.length + 2];
        
        for(int i=1; i<num.length + 1; i++) {
            copy[i] = num[i-1];
        }
        copy[0] = Integer.MIN_VALUE;
        copy[num.length + 1] = Integer.MIN_VALUE;
        int i;
        for(i=1; i<num.length + 2; i++) {
            if(copy[i]>copy[i-1] && copy[i]>copy[i+1]) break;
        }
        return i-1;
    }
}

//another O(n)
public class Solution {
     public int findPeakElement(int[] num) {
        for (int i = 1; i < num.length - 1; i++) {
            if (num[i] > num[i - 1] && num[i] > num[i + 1])
                return i;
        }
        return (num.length == 1 || num[0] > num[1]) ? 0 : num.length - 1;
    }   
}


//O(logn)

public int findPeakElement(int[] num) {
        int start = 0;
        int end = num.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] < num[mid + 1])
                start = mid + 1;
            else
                end = mid;
        }
        return start;
}