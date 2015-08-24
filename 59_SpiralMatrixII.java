// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// For example,
// Given n = 3,

// You should return the following matrix:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]


public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n == 0) return res;
        int rowBegin = 0;
        int rowEnd = n-1;
        int colBegin = 0;
        int colEnd = n-1;
        int num = 1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            for(int i=colBegin; i<=colEnd; i++) {
                res[rowBegin][i] = num++;
            }
            rowBegin++;
            
            for(int i=rowBegin; i<=rowEnd; i++) {
                res[i][colEnd] = num++;
            }
            colEnd--;
            
            for(int i=colEnd; i>=colBegin; i--) {
                if(rowBegin <= rowEnd) {
                    res[rowEnd][i] = num++;
                }
            }
            rowEnd--;
            
            for(int i=rowEnd; i>=rowBegin; i--) {
                if(colBegin <= colEnd) {
                    res[i][colBegin] = num++;
                }
            }
            colBegin++;
        }
        return res;
    }
}