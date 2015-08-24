/*
 * Write a function to find the longest common prefix string amongst an array 
 * of strings.
 */


//best
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        int right_most = strs[0].length();
        for(int i = 1; i < strs.length; i++) {
            right_most = Math.min(right_most, strs[i].length());
            for(int j = 0; j < right_most; j++) {
                if(strs[0].charAt(j) != strs[i].charAt(j)) {
                    right_most = j;
                    break;
                }
            }
        }
        return strs[0].substring(0, right_most);
    } 
}
//lazy
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length < 1 || strs[0].length() < 1)return "";
        String temp = strs[0];
        String res = temp;
        int len = res.length();
        for(int i=1; i<strs.length; i++) {
            if(strs[i].length() < 1) return "";
            len = Math.min(res.length(), strs[i].length());
            temp = getCommon(res, strs[i], len);
            res = temp.length() < res.length() ? temp : res;
            if(res.equals(""))break;
        }
        return res;
    }
    
    private String getCommon(String s1, String s2, int len) {
        String res = "";
        // int len = Math.min(s1.length(), s2.length());
        for(int i=0; i<len; i++) {
            if(s1.charAt(i) == s2.charAt(i)) {
                res += s1.charAt(i);
            } else break;
        }
        return res;
    }
}