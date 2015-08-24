/*
 * Given a string containing just the characters '(', ')', '{', 
 * '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and 
 * "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            if(ch == ')' && (stack.isEmpty() || stack.pop() != '('))
                return false;
            if(ch == ']' && (stack.isEmpty() || stack.pop() != '['))
                return false;
            if(ch == '}' && (stack.isEmpty() || stack.pop() != '{'))
                return false;
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}

//
public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else if (stack.isEmpty() || s.charAt(i) - stack.pop() > 2)
                return false;
        }
        return stack.isEmpty();
    }