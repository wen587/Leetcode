// Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

// For example, given the following matrix:

// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0
// Return 4.


//O(m*n) space
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length < 1) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int res = 0;
        for(int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            res = Math.max(res, dp[i][0]);
        }
        for(int j = 0; j < col; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            res = Math.max(res, dp[0][j]);
        }
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        
        return res * res;
    }
}



//O(n) space
public int maximalSquare(char[][] matrix) {
    if(matrix == null || matrix.length ==0|| matrix[0].length == 0) return  0;

    int[] dp = new int[matrix[0].length +1];
    int max = 0;
    int tmp1 = 0;
    int tmp2 = 0;

    for(int i=0; i< matrix.length; i++)
    {
        tmp1 = 0;
        for(int j=0; j< matrix[0].length; j++)
        {
            tmp2 = dp[j+1];

            if(matrix[i][j] == '1')
            {
                dp[j+1] = Math.min(tmp1, Math.min(dp[j], dp[j+1])) + 1;
                max = Math.max(max, dp[j+1]);
            }
            else
            {
                dp[j+1] = 0;
            }

            tmp1 = tmp2;
        }
    }

    return max*max;
}