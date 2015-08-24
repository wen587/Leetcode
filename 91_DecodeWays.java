// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.

// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

// The number of ways decoding "12" is 2.
//O(n) space dp
public class Solution {
    public int numDecodings(String s) {
        if(s.length() < 1 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=1; i<s.length(); i++) {
            char pre = s.charAt(i - 1);
            char cur = s.charAt(i);
            if(cur == '0') {
                dp[i] = 0;
            }
            if(pre == '1' || pre == '2' && cur - '0' <= 6) {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[s.length()];
    }
}
//O(1)space dp
public class Solution {
    public int numDecodings(String s) {
        if(s.length() < 1 || s.charAt(0) == '0') return 0;
        int d1 = 1; //decode ways of s[i - 1]; while d2 _ decode ways of s[i - 2];
        int d2 = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                d1 = 0;
            }
            if(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) - '0' <= 6) {
                d1 = d2 + d1;
                d2 = d1 - d2;
            } else {
                d2 = d1;
            }
        }
        return d1;
    }
}