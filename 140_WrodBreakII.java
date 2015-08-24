// Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

// Return all such possible sentences.

// For example, given
// s = "catsanddog",
// dict = ["cat", "cats", "and", "sand", "dog"].

// A solution is ["cats and dog", "cat sand dog"].



//simpler than mine but still get TLE
public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        Map<Integer, List<String>> validMap = new HashMap<Integer, List<String>>();

        // initialize the valid values
        List<String> l = new ArrayList<String>();
        l.add("");
        validMap.put(s.length(), l);

        // generate solutions from the end
        for(int i = s.length() - 1; i >= 0; i--) {
            List<String> values = new ArrayList<String>();
            for(int j = i + 1; j <= s.length(); j++) {
                if (dict.contains(s.substring(i, j))) {
                    for(String word : validMap.get(j)) {
                        values.add(s.substring(i, j) + (word.isEmpty() ? "" : " ") + word);
                    }
                }
            }
            validMap.put(i, values);
        }
        return validMap.get(0);
    }
}

//AC
public class Solution {
    private final Map<String, List<String>> cache = new HashMap<>();
    public List<String> wordBreak(String s, Set<String> set) {
        if (cache.containsKey(s)) return cache.get(s);
        List<String> res = new LinkedList<>();
        if (set.contains(s)) res.add(s);
        for(int i=1; i<s.length(); i++) {
            String left = s.substring(0, i), right = s.substring(i);
            if(set.contains(left) && conSuffix(set, right)) {
                for(String ss : wordBreak(right, set)) {
                    res.add(left + " " + ss);
                }
            }
        }
        cache.put(s, res);
        return res;
    }
    private boolean conSuffix(Set<String> set, String str) {
        for(int i=0; i<str.length(); i++) {
            if(set.contains(str.substring(i)))return true;
        }
        return false;
    }
}
