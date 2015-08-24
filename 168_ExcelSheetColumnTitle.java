/*
 * Given a positive integer, return its corresponding 
 * column title as appear in an Excel sheet.
 * For example:
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB 
 * 
 */

//recursive
return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));

//iterative

public class Solution {
    public String convertToTitle(int n) {
        String res = "";
        
        while(n > 0) {
            n--;
            res = (char) (n % 26 + 'A') + res;
            n /= 26;
        }
        // res = (char) (n % 26 + 'A') + res;
        return res;
    }
}
//
public class Solution {
    public String convertToTitle(int n) {
        String s = "";
        while(true) {
            n = n - 1;
            s = (char)(n%26 + 'A') + s;
            n = n/26;
            if(n==0) break;
        }
        return s;
    }
}
