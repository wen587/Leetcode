/*
 * Given a column title as appear in an Excel sheet, 
 * return its corresponding column number.
 * For example:
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 */
//recursive
public int titleToNumber(String s) {
		int res = 0;
		int temp = 0;
		if(s.equals("")) {//here should use equals , if use "==" will give wrong answer
			return res;
		} else {
			temp = s.charAt(s.length() - 1) - 'A' + 1;
			res = 26*titleToNumber(s.substring(0, s.length() - 1)) + temp;
		}
		return res;
//        return s == "" ? 0 : 26*titleToNumber(s.substring(0,s.length()-1)) + s.charAt(s.length()-1) -'A'+1;
    }


public class Solution {
        public int titleToNumber(String s) {
        int n = s.length();
        int res = 0;
        for(int i=0; i<n; i++){
            int m =  ((int) (s.charAt(i)) - 64) ;
            res = m + res*26;
        }
        return res;
    }
}