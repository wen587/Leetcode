// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// "((()))", "(()())", "(())()", "()(())", "()()()"
https://leetcode.com/discuss/18162/my-accepted-java-solution
//recursive
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, 0, 0, "", res);
        return res;
    }
    private void helper(int n, int l, int r, String s, List<String> list) {
        if(l == n && r == n) {
            list.add(s);
            return;
        }
        if(l < n) {
            helper(n, l + 1, r, s + "(", list);
        }
        if(r < n && r < l) {
            helper(n, l, r + 1, s + ")", list);
        }
    }
}

//smart Hashset
public List<String> generateParenthesis(int n) {
    List<String> result = new LinkedList<>();
    result.add("()");
    for (int i = 1; i < n; ++i) {
        Set<String> buffer = new HashSet<>();
        for (int j = 0; j < result.size(); ++j) {
            String str = result.get(j);
            for (int k = 0; k < str.length(); ++k) {
                    buffer.add(str.substring(0, k) + "()" 
                        + str.substring(k, str.length()));
            }
        }
        result.clear();
        result.addAll(buffer);
    }
    return result;
// n=1, it is "()"
// n=2, we need to add a new () into all locations of "()": ()(), (()) 
// and ()(). Just remember to remove duplicates. So the final result is:
// ()() and (())