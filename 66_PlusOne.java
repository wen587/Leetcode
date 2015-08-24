/*
 * Given a number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head 
 * of the list.
 */

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i>=0; i--) {
            int temp = digits[i];
            digits[i] = (digits[i] + carry) % 10;
            carry = (temp + carry)/10;
        }
        if(carry == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}


//
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length - 1;
        while(len >= 0) {
            if(digits[len] == 9) {
                digits[len] = 0;
                len--;
            } else {
                digits[len]++;
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
