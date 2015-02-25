/*
 * Given a number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head 
 * of the list.
 */

public class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        for(int i=digits.length - 1; i>0; i--) {
            if(digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1] += 1;
            }
        }
        if(digits[0] == 10) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            res[1] = 0;
            for(int i=1; i<res.length - 1; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }
        return digits;
    }
}


//
public class Solution {
    public int[] plusOne(int[] digits) {
        for (int i=digits.length-1; i>=0; i--) {
             
            if (digits[i]==9) {
                digits[i]=0;
                continue;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
         
        // digits[0]==0
        int[] newDigits = new int[digits.length+1];
         
        newDigits[0] = 1;
        System.arraycopy(digits, 0, newDigits, 1, digits.length-1);
         
        return newDigits;
    }
