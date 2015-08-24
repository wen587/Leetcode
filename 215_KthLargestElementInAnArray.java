// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

// For example,
// Given [3,2,1,5,6,4] and k = 2, return 5.

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ array's length.


//quickSort modified for O(n) time
//T(n) = T(n / 2) + O(n); //O(n) is partition time
public class Solution {
    private void shuffle(int[] nums) {//shuffle array, random [0, 1)
        for(int i=0; i<nums.length; i++) {
            int s = i + (int) (Math.random() * (nums.length - i));
            swap(nums, i, s);
        }
    }
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        int start = 0;
        int end = nums.length - 1;
        while(true) {
            int pivot = partition(nums, start, end);
            if(pivot == nums.length - k) return nums[pivot];
            else if(pivot > nums.length - k) end = pivot - 1;
            else start = pivot + 1;
        }
        
    }
    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int pIndex = start;
        for(int i=start; i< end; i++) {
            if(nums[i] < pivot) {
                swap(nums, i, pIndex);
                pIndex++;
            }
        }
        swap(nums, pIndex, end);
        return pIndex;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//quickSort
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length -1 );
        return nums[nums.length - k];
        
    }
    private void quickSort(int[] nums, int start, int end) {
        if(start < end) {
            int pivot = partition(nums, start, end);
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }
    }
    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int pIndex = start;
        for(int i=start; i< end; i++) {
            if(nums[i] < pivot) {
                swap(nums, i, pIndex);
                pIndex++;
            }
        }
        swap(nums, pIndex, end);
        return pIndex;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//MergeSort
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        mergeSort(nums);
        return nums[nums.length - k];
        
    }
    private void mergeSort(int[] nums) {
        if(nums.length < 2) return;
        int[] a = new int[nums.length / 2];
        int[] b = new int[nums.length - nums.length / 2];
        for(int i=0; i<a.length; i++) a[i] = nums[i];
        for(int j=0; j<b.length; j++) b[j] = nums[a.length + j];
        mergeSort(a);
        mergeSort(b);
        merge(nums, a, b);
    }
    private void merge(int[] nums, int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                nums[k++] = a[i++];
            } else {
                nums[k++] = b[j++];
            }
        }
        while(i < a.length) {
            nums[k++] = a[i++];
        }
        while(j < b.length) {
            nums[k++] = b[j++];
        }
    }
}

//insertion sort
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        insertionSort(nums);
        return nums[nums.length - k];
    }
    private void insertionSort(int[] nums) {
        for(int i = 1; i<nums.length; i++) {
            int value = nums[i];
            int hole = i;
            while(hole > 0 && nums[hole - 1] > value) {
                nums[hole] = nums[hole - 1];
                hole--;
            }
            nums[hole] = value;
        }
    }
}
//seletion sort
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        selectionSort(nums);
        return nums[nums.length - k];
        
    }
    private void selectionSort(int[] nums) {
        for(int i=0; i<nums.length - 1; i++) {
            int iMin = i;
            for(int j = i + 1; j<nums.length; j++) {
                if(nums[j] < nums[iMin]) iMin = j;
            }
            int temp = nums[iMin];
            nums[iMin] = nums[i];
            nums[i] = temp;
        }
    }
}

//bubble sort
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        bubbleSort(nums);
        return nums[nums.length - k];
        
    }
    private void bubbleSort(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int flag = 0;
            for(int j=0; j<nums.length - i - 1; j++) {
                if(nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = 1;
                }
            }
            if(flag == 0) return;
        }
    }
}