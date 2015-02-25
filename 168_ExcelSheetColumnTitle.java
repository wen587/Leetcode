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
