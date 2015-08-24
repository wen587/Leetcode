/*
 * Given a string, find the length of the longest substring 
 * without repeating characters. For example, the longest 
 * substring without repeating letters for "abcabcbb" is 
 * "abc", which the length is 3. For "bbbbb" the longest 
 * substring is "b", with the length of 1.
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int slow = 0, fast = 0, max = 0;
        // map.put(s.charAt(0), 0);
        // fast ++;
        while(fast < s.length()) {
            char ch = s.charAt(fast);
            if(slow == fast) {
                map.put(ch, fast);
                fast ++;
                continue;
            }
            if(map.containsKey(ch)) {
                max = Math.max(max, fast - slow);
                int newSlow = map.get(ch) + 1;
                for(int i=slow; i< newSlow; i++) {
                    map.remove(s.charAt(i));
                }
                slow = newSlow;
            } else {
                map.put(ch, fast);
                fast++;
            }
        }
        return Math.max(max, fast - slow);
    }
}
//anotehr solution
public int lengthOfLongestSubstring(String s) {
        boolean[] occur = new boolean[127];
        int result = 0;
        for (int i = 0, j = 0; j < s.length(); i++) {
            for (; j < s.length() && !occur[s.charAt(j)]; j++) {
                occur[s.charAt(j)] = true;
            }
            result = Math.max(result, j - i);
            occur[s.charAt(i)] = false;
        }
        return result;
    }