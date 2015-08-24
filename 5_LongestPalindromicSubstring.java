/*
 * Given a string S, find the longest palindromic substring in S. You may assume that the 
 * maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
//manachar's algorithm O(n)
http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
// center expand  O(n^2) time  O(1) space
public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i=0; i<s.length(); i++) {
            String s1 = expand(s, i, i);
            if(s1.length() > res.length() ) res = s1;
            String s2 = expand(s, i, i+1);
            if(s2.length() > res.length() ) res = s2;
        }
        return res;
    }
    private String expand(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}