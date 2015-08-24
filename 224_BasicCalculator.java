// Implement a basic calculator to evaluate a simple expression string.

// The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

// You may assume that the given expression is always valid.

// Some examples:
// "1 + 1" = 2
// " 2-1 + 2 " = 3
// "(1+(4+5+2)-3)+(6+8)" = 23


public class Solution {
    public int calculate(String s) {
        int num = 0, res = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if(c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if(c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if(c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if(c == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        res += num * sign;
        return res;
    }
}