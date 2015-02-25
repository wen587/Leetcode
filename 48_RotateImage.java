/*
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 */

//有点笨 多用了空间
public class Solution {
    public void rotate(int[][] matrix) {
        int[][] dummy = new int[matrix.length][matrix.length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                dummy[i][j] = matrix[i][j];
            }
        }
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length; j++) {
                 matrix[j][matrix.length - 1 - i] = dummy[i][j];
            }
        }
    }
}

//屌一点的方法
 /**
     * (i,j) => (j,n-i)
     * (j,n-i) => (n-i,n-j)
     * (n-i,n-j) => (n-j,i)
     * (n-j,i) => (i,j)
     **/
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length-1;
         
        for (int i=0; i<=n; i++) {
            for (int j=i+1; j<=n-i; j++) {
                int n1 = matrix[i][j];
                int n2 = matrix[j][n-i];
                int n3 = matrix[n-i][n-j];
                int n4 = matrix[n-j][i];
                 
                matrix[i][j] = n4;
                matrix[j][n-i] = n1;
                matrix[n-i][n-j] = n2;
                matrix[n-j][i] = n3;
            }
        }
    }
}