// Given an input string, reverse the string word by word.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

// Update (2015-02-12):
// For C programmers: Try to solve it in-place in O(1) space.

// click to show clarification.

// Clarification:
// What constitutes a word?
// A sequence of non-space characters constitutes a word.
// Could the input string contain leading or trailing spaces?
// Yes. However, your reversed string should not contain leading or trailing spaces.
// How about multiple spaces between two words?
// Reduce them to a single space in the reversed string.


public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if(s.length() < 1) return "";
        String[] strs = s.split(" ");
        int i = 0;
        int j = strs.length - 1;
        while( i < j) {
            String temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
            i++;j--;
        }
        String res = strs[0];
        i = 1;
        for(i = 1; i< strs.length; i++) {
            if(strs[i].equals("")) continue;
            res = res + " " + strs[i];
        }
        return res;
    }
}

//no built in function
public class Solution {
    public String reverseWords(String s) {
        // if(s.length() < 2) return s;
        String res = "";
        int pos = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') {
                if(i > pos) {
                    res = s.substring(pos, i) + " " + res;
                }
                pos = i + 1;
            } else if(i == s.length() - 1) {
                res = s.substring(pos, i + 1) + " " + res;
            }
        }
        return res.length() == 0 ? "" : res.substring(0, res.length() - 1);
    }
}