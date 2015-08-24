/*
 * Given a string, determine if it is a palindrome, considering only 
 * alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question 
 * to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */

public class Solution {
    public boolean isPalindrome(String s) {
        if(s == "") return true;
        int i = 0, j = s.length() - 1;
        while(i <= j) {
            char start = s.charAt(i);
            char end = s.charAt(j);
            if(start < '0' || start > '9' && start < 'A' || start > 'Z' & start < 'a' || start > 'z') i++;
            else if (end < '0' || end > '9' && end < 'A' || end > 'Z' & end < 'a' || end > 'z') j--;
            else if (start - end != 0 && Math.abs(start - end) != 'a' - 'A') return false;
            else {
                i++; j--;
            }
        }
        return true;
    }
}