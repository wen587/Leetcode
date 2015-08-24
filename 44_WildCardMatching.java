// Implement wildcard pattern matching with support for '?' and '*'.

// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).

// The matching should cover the entire input string (not partial).

// The function prototype should be:
// bool isMatch(const char *s, const char *p)

// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "*") → true
// isMatch("aa", "a*") → true
// isMatch("ab", "?*") → true
// isMatch("aab", "c*a*b") → false

// O(n^2)
// it is O(m*n) in worst cases, consider below input:

// s = "aaaaaaaaaaaaaaaaaaaa"

// p = "*aaaaaaaaaaaaaaaaaab"
public class Solution {
    public boolean isMatch(String s, String p) {
        int cnt = 0;
        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '*')cnt++;
        }
        if(cnt == 0 && p.length() < s.length() )return false;
        if(p.length() - cnt > s.length()) return false;
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int match = 0;
        while(i < s.length() ) {
            if(j < p.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                i++;j++;
            } else if (j < p.length() && p.charAt(j) == '*' ) {
                starIndex = j;
                match = i;
                j++;
            } else if(starIndex != -1) {
                j = starIndex + 1;
                match++;
                i = match;
            } else return false;
        }
        while(j < p.length() && p.charAt(j) == '*' ) {
            j++;
        }
        return j == p.length();
    }
}


//same

public class Solution {
    public boolean isMatch(String s, String p) {
        char[] S = s.toCharArray();
        char[] P = p.toCharArray();
        int checkpointS = -1;
        int checkpointP = -1;
        int j = 0;
        for(int i = 0; i < S.length; /*void*/){
            if(j < P.length) {
                if(S[i] == P[j] || P[j] == '?'){
                    i++;
                    j++;
                    continue;
                }   
                if(P[j] == '*'){
                    checkpointS = i;
                    checkpointP = j;
                    j++;
                    continue;
                }
            }
            // mismatch
            if(checkpointS >= 0){
                checkpointS++;
                // restore
                i = checkpointS;
                j = checkpointP + 1;
                continue;
            }
            return false;
        }
        while(j < P.length) {
            if(P[j] == '*'){
                j++;
            } else {
                return false;
            }
        }
        return true;
    }
}