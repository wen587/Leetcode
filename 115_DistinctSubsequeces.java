// Given a string S and a string T, count the number of distinct subsequences of T in S.

// A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

// Here is an example:
// S = "rabbbit", T = "rabbit"

// Return 3.


//O(mn) space dp
public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int i=0; i<s.length(); i++) {
            dp[i][0] = 1;
        }
        for(int i=1; i<s.length() + 1; i++) {
            for(int j = 1; j<t.length() + 1; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}

//row and col change 
public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for(int j = 0; j <= s.length(); j++) {
            dp[0][j] = 1;
        }
        for(int i=0; i<t.length(); i++) {
            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == t.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
                }
        }
        return dp[t.length()][s.length()];
    }
}