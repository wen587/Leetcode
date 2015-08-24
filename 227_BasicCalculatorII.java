// Implement a basic calculator to evaluate a simple expression string.

// The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

// You may assume that the given expression is always valid.

// Some examples:
// "3+2*2" = 7
// " 3/2 " = 1
// " 3+5 / 2 " = 5
// Note: Do not use the eval built-in library function.


public class Solution {
    public int calculate(String s) {
        int num = 0, res = 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if(sign == '+') stack.push(num);
                if(sign == '-') stack.push(-num);
                if(sign == '*') stack.push(stack.pop() * num);
                if(sign == '/') stack.push(stack.pop() / num);
                num = 0;
                sign = c;
            }
        }
        for(int n : stack) res += n;
        return res;
    }
}