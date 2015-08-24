/*
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100". 
 */


public class Solution {
    public String addBinary(String a, String b) {
        String res = "";
        int len = Math.max(a.length(), b.length());
        int carry = 0;
        for(int i=0; i<len; i++) {
            int ca = i <a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            int cb = i <b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            res =  (ca + cb + carry) % 2 + res;
            carry = (ca + cb + carry) / 2;
        }
        if(carry > 0)
        return 1 + res;
        return res;
    }
}

//
public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        String res = "";
        int temp = 0;
        while(i >= 0 || j >= 0) { // or add condition temp == 1, then we can eliminate the judge of temp == 1 later
            temp += i>=0 ? a.charAt(i--) - '0' : 0;
            temp += j>=0 ? b.charAt(j--) - '0' : 0;
            res = temp % 2 + res;
            temp = temp / 2;
        }
        if(temp == 1) {
            res = 1 + res;
        }
        return res;
    }
}