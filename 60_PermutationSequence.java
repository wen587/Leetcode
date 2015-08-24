// The set [1,2,3,…,n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order,
// We get the following sequence (ie, for n = 3):

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

// Note: Given n will be between 1 and 9 inclusive.
//iterative
public class Solution {
    public String getPermutation(int n, int k) {
        int num = 1;
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            list.add(i);
            num *= i;
        }
        k--;
        String res = "";
        for(int i=n; i>0; i--) {
            num = num/i;
            int index = k / num;
            res = res + list.get(index);
            list.remove(index);
            k = k % num;
        }
        return res;
    }
}

