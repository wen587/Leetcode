/*
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if 
 * you have already thought through this!
 * If the integer's last digit is 0, what should the output be? ie, cases such
 * as 10, 100.
 * Did you notice that the reversed integer might overflow? Assume the input 
 * is a 32-bit integer, then the reverse of 1000000003 overflows. How should 
 * you handle such cases?
 * Throw an exception? Good, but what if throwing an exception is not an 
 * option? You would then have to re-design the function (ie, add an extra 
 * parameter). 
 */
//
public class Solution {
    public int reverse(int x) {
        boolean negative = false;
        int res = 0;
        if(x < 0)  {
            if(x == Integer.MIN_VALUE) return 0;
            x = -x;
            negative = true;
        }
        while(x / 10 != 0) {
            res = 10 * res + x % 10;
            if(res > Integer.MAX_VALUE / 10 
            // || (res == Integer.MAX_VALUE / 10 && x % 10 > 7)
            ) return 0;
            x /= 10;
        }
        res = 10 * res + x;
        return negative ? -res : res;
    }
}
//

public class Solution {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = 10 * res + x % 10;
            x /= 10;
            if(res> Integer.MAX_VALUE) return 0;
            if(res< Integer.MIN_VALUE) return 0;
        }
        return (int)res;
    }    
}