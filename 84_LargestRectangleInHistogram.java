/*
 * Given n non-negative integers representing the histogram's bar height where the 
 * width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */

//
public class Solution {
    public int largestRectangleArea(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<=height.length; i++) {
            int curH = 0;
            if(i != height.length) {
                 curH = height[i];
            }
            
            // if(stack.isEmpty() || curH >= height[stack.peek()]) {
            //     stack.push(i);
            // } else {
            //     int k = stack.pop();
            //     res = Math.max(res, height[k] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
            //     i--;
                
            // }
            while(!stack.isEmpty() && curH < height[stack.peek()]) {
                int var = stack.pop();
                res = Math.max(res, height[var] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                  
            }
            stack.push(i);
        }
        return res;
    }
}

