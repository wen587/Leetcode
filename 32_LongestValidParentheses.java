/*
 * Given a string containing just the characters '(' and ')', find the length 
 * of the longest valid (well-formed) 
 * parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has 
 * length = 2.
 * Another example is ")()())", where the longest valid parentheses substring 
 * is "()()", which has length = 4.
 */
//simple dp
public class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int res = 0;
        int stack = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') stack++;
            else if (stack > 0) {
                dp[i] = 2 + dp[i - 1];
                if(i - dp[i] > 0) {
                    dp[i] += dp[i - dp[i]];
                }
                stack--;
                res = Math.max(res, dp[i]);
                 
            }
        }
        return res;
    }
}


//combine stack with dp 0.0
public class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') stack.push(i);
            else {
                if(!stack.isEmpty()) {
                    int temp = stack.pop();
                    dp[i] = 2 + dp[i - 1];
                    if(i - dp[i] > 0) {
                        dp[i] += dp[i - dp[i]];
                    }
                    res = Math.max(res, dp[i]);
                } 
            }
        }
        return res;
    }
}


//stack
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i=0; i<s.length(); i++ ) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    int lastPos = -1;
                    if(!stack.isEmpty()) {
                        lastPos = stack.peek();
                    }
                    int cur = i - lastPos;
                    max = Math.max(max, cur);
                } else {
                    stack.push(i);
                }
            }
        }
        return max;
    }
}

//dp
public int longestValidParentheses(String s) {
    cchar[] S = s.toCharArray();
        int[] V = new int[S.length];
        int open = 0;
        int max = 0;
        for(int i=0; i<S.length; i++) {
            if(S[i] == '(') open++;
            else if(open > 0) {
                V[i] = 2 + V[i - 1];
                if(i - V[i] > 0) {
                    V[i] += V[i - V[i]];
                }
                open--;
            }
            max = Math.max(max, V[i]);
        }
        return max;
}