// Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.


//dp O(n^3)time O(n)space
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length < 1) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[col];
        int res = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(matrix[i][j] == '1') dp[j] += 1;
                else dp[j] = 0;
                
            }
            for(int j=0; j<col; j++) {
                int l = j; int r = j;
                while(l >=0 && dp[l] >= dp[j]) l--;
                while(r < col && dp[r] >= dp[j]) r++;
                res = Math.max(res, dp[j] * (r - l -1));
            }
            
        }
        return res;
    }
}

//stack
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length < 1) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;
        int[] h = new int[col + 1];
        for(int i=0; i<row; i++) {
            Stack<Integer> stack = new Stack<>();
            for(int j=0; j<=col; j++) {
                if(j < col) {
                    if(matrix[i][j] == '1') h[j] += 1;
                    else h[j] = 0;
                }
                
                // if(stack.isEmpty() || height[j] >= height[stack.peek()]) {
                //     stack.push(j);
                // } else {
                    while(!stack.isEmpty() && height[j] < height[stack.peek()]) {
                        int temp = stack.pop();
                        res = Math.max(res, height[temp] * (stack.isEmpty() ? j : j - stack.peek() - 1));
                    }
                    stack.push(j);
                    
                // }
                }
        }
        return res;
    }
}