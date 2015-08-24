// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".

// Note:
// If there is no such window in S that covers all characters in T, return the emtpy string "".

// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

public class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        Map<Character, Integer> toFind = new HashMap<>();
        Map<Character, Integer> hasFound = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            if(!toFind.containsKey(t.charAt(i))) {
                toFind.put(t.charAt(i), 1);
            } else {
                toFind.put(t.charAt(i), toFind.get(t.charAt(i)) + 1);
            }
        }
        int cnt = 0;
        int minLen = Integer.MAX_VALUE;
        for(int l=0, r=0; r<s.length(); r++) {
            char cur = s.charAt(r);
            if(toFind.containsKey(cur)) {
                if(!hasFound.containsKey(cur)) {
                    hasFound.put(cur, 1);
                } else {
                    hasFound.put(cur, hasFound.get(cur) + 1);
                }
                if(hasFound.get(cur) <= toFind.get(cur)) cnt++;
                if(cnt == t.length()){
                    char rmv = s.charAt(l);
                    while(!toFind.containsKey(rmv) || hasFound.get(rmv) > toFind.get(rmv)) {
                        if(hasFound.containsKey(rmv)) {
                            hasFound.put(rmv, hasFound.get(rmv) - 1);
                        }
                        rmv = s.charAt(++l);
                    }
                    if(r - l + 1 < minLen) {
                        minLen = r - l + 1;
                        res = s.substring(l, r + 1);
                    }
                }
            }
        }
        return res;
    }
}