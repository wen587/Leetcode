// Given two strings s and t, determine if they are isomorphic.

// Two strings are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

// For example,
// Given "egg", "add", return true.

// Given "foo", "bar", return false.

// Given "paper", "title", return true.

// Note:
// You may assume both s and t have the same length.


public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        // if(s.length() < 1) return true;
        for(int i=0; i<s.length(); i++) {
            char sCur = s.charAt(i);
            char tCur = t.charAt(i);
            if(!map.containsKey(sCur)) {
                if(map.containsValue(tCur)) return false;
                map.put(sCur, tCur);
                
            } else {
                if(tCur !=map.get(sCur)) {
                    return false;
                }
            }
        }
        return true;
    }
}
///

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sArr = new int[256];
        int[] tArr = new int[256];
        for(int i=0; i<s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if(sArr[s1] != tArr[t1]) return false;
            sArr[s1] = i + 1;  //dont use += 1 to prevent case "aba" "baa"
            tArr[t1] = i + 1;
        }
        return true;
    }
}