// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return all possible palindrome partitioning of s.

// For example, given s = "aab",
// Return

//   [
//     ["aa","b"],
//     ["a","a","b"]
//   ]

//BT
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> list = new ArrayList<>();
        helper(s, 0, list, res);
        return res;
    }
    private void helper(String s, int pos, List<String> list, List<List<String>> res) {
        if(pos == s.length()) {
            res.add(new ArrayList<String>(list));
            // res.add(list);
            return;
        }
        for(int i = pos + 1; i<=s.length(); i++) {
            String prefix = s.substring(pos, i);
            if(!isPalindrome(prefix)) continue;
            list.add(prefix);
            helper(s, i, list, res);
            list.remove(list.size() - 1);
        }
    }
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r))return false;
            l++; r--;
        }
        return true;
    }
}