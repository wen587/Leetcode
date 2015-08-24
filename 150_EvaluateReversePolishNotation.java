/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
//规范
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if(!isSign(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int r = stack.pop();
                int l = stack.pop();
                int res = 0;
                res = select(token, l, r, res);
                stack.push(res);
            }
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }
    private int select(String s, int l, int r, int res) {
        switch(s) {
            case "+" : res = l + r;
                       break;
            case "-" : res = l - r;
                       break;
            case "*" : res = l * r;
                       break;
            case "/" : res = l / r;
                       break;
            default :  res = 0;
                       break;
        }
        return res;
    }
    private boolean isSign(String s) {
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return true;
        } 
        return false;
    }
}


//
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<tokens.length; i++) {
            if(tokens[i].equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            } else if(tokens[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if(tokens[i].equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            } else if(tokens[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}