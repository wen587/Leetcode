// Given a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.



// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// Note:
// Although the above answer is in lexicographical order, your answer could be in any order you want.


//dfs
public class Solution {
    public List<String> letterCombinations(String digits) {
        
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<String>();
        if(digits.length() < 1) return res;
        helper(digits, 0, res, map, "");
        return res;
    }
    public void helper(String digits, int pos, List<String> res, String[] map, String pre) {
        if(pos == digits.length()) {
            res.add(pre);
            return;
        }
        int mapPos = digits.charAt(pos) - '0';
        for(Character ch : map[mapPos].toCharArray()) {
            helper(digits, pos + 1, res, map, pre + ch);
        } 
    }
}
//bt
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() < 1) return res;
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for(int i=0; i<digits.length(); i++) {
            res = helper(res, map[digits.charAt(i) - '0']);
        }
        return res;
    }
    private List<String> helper(List<String> list, String map) {
        List<String> res = new ArrayList<>();
        for(int i=0; i<map.length(); i++) {
            for(String s : list) {
                res.add(s + map.charAt(i));
            }
        }
        return res;
    }
}
