/*
Implement next permutation, which rearranges numbers into the lexicographically 
next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible 
order (ie, sorted in ascending order).
The replacement must be in-place, do not allocate extra memory.
Here are some examples. Inputs are in the left-hand column and its corresponding 
outputs are in the right-hand column.
1,2,3 ¡ú 1,3,2
3,2,1 ¡ú 1,2,3
1,1,5 ¡ú 1,5,1
 * 
 */


public class Solution {
    public void nextPermutation(int[] num) {
        for(int i=num.length - 1; i>0; i--) {
            if(num[i-1]<num[i]) {
                // find out the minimum number which is larger than num[i-1]
                int pos = -1;
                int min = Integer.MAX_VALUE;
                for(int j=i; j<num.length; j++) {
                    if(num[j]>num[i-1] && num[j]<min) {
                        min = num[j];
                        pos = j;
                    }
                }
                
                // num[i-1] ^= num[pos];
                // num[pos] ^= num[i-1];
                // num[i-1] ^= num[pos];
                int right = num[pos];
                num[pos] = num[i-1];
                num[i-1] = right;
                
                Arrays.sort(num, i, num.length);
                return;
            }
        }
        Arrays.sort(num);
        return;
    }
}