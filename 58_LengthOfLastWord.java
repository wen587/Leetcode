/*
 * Given a string s consists of upper/lower-case alphabets and empty space 
 * characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space 
 * characters only.
 * For example, 
 * Given s = "Hello World",
 * return 5.
 */


public class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        
        while(i >= 0 && s.charAt(i) == ' ') {
            --i;
        }
        
        int length = 0;
        while(i >= 0 && s.charAt(i) != ' ') {
            ++length;
            --i;
        }
        
        return length;
    }
}


//智能
public int lengthOfLastWord(String s) {
        if(s.length() == 0)
            return 0;
        String[] arrays = s.split(" ");
        if(arrays.length == 0)
            return 0;
        return arrays[arrays.length - 1].length();
    }