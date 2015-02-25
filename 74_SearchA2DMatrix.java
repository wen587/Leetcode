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


public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int targetRow = 0;
        for(int i=m-1; i>=0; i--) {
            if(target >= matrix[i][0]) {
                targetRow = i;
                break;
            }
        }
        for(int j=0; j<n; j++) {
            if(matrix[targetRow][j] == target) return true;
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

//log(m) + log(n)
class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        int n = matrix.size() - 1, m = matrix[0].size() - 1;
        int l = 1, r = n;
        // Let's find a row where may be our target
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (matrix[mid - 1][m] == target) return true;
            if (matrix[mid - 1][m] > target) r = mid - 1; else l = mid + 1;
        }
        int row = r;            
        l = 0, r = m;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] > target) r = mid - 1; else l = mid + 1;
        }
        return false;
    }
};

