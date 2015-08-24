/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the 
 * previous row.
 *
 * For example,
 * Consider the following matrix:
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */

//Mine smart slt
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int t = 0, d = matrix.length - 1;
        int row = 0;
        while(t <= d) {
            int mid = (t + d) / 2;
            if(target < matrix[mid][0]) {
                d = mid - 1;
            } else  {
                row = mid;
                t = mid + 1;
            }
        }
        int l = 0, r = matrix[row].length - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(target == matrix[row][mid]) return true;
            else if(target > matrix[row][mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}

//consider a list
public boolean searchMatrix(int[][] matrix, int target) {
        int yLen = matrix[0].length;
        int i = 0; 
        int j = matrix.length * yLen;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (matrix[mid / yLen][mid % yLen] == target)
                return true;
            else if (matrix[mid / yLen][mid % yLen] < target)
                i = mid + 1;
            else 
                j = mid;
        }
        return false;
    }

