// Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

// For example, given the range [5, 7], you should return 4.


public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int move = 1;
        while(m != n) {
            m = (m >> 1);
            n = (n >> 1);
            move = (move << 1);
        }
        return m * move;
    }
}