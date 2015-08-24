// Given a matrix of m x n elements (m rows, n columns), return all 
// elements of the matrix in spiral order.

// For example,
// Given the following matrix:

// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// You should return [1,2,3,6,9,8,7,4,5].


//nice sol
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return res;
    }
}


//another one
public class Solution {
    private static final int UP = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;
    private static final int RIGHT = 4;
     
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length==0 || matrix[0].length==0)
            return list;
 
        int direction = RIGHT;
         
        int boundUp = 0;
        int boundDown = matrix.length;
        int boundLeft = -1;
        int boundRight = matrix[0].length;
         
        int x=0;
        int y=0;
         
        while (boundUp<boundDown && boundLeft<boundRight) {
            list.add(matrix[y][x]);
             
            switch (direction) {
                case RIGHT:
                    if (x<boundRight-1) {
                        x++;
                    } else if (y<boundDown-1) {
                        y++;
                        direction = DOWN;
                        boundRight--;
                    } else {
                        return list;
                    }
                    break;
                case DOWN:
                    if (y<boundDown-1) {
                        y++;
                    } else if (x>boundLeft+1) {
                        x--;
                        direction = LEFT;
                        boundDown--;
                    } else {
                        return list;
                    }
                    break;
                case LEFT:
                    if (x>boundLeft+1) {
                        x--;
                    } else if (y>boundUp+1) {
                        y--;
                        direction = UP;
                        boundLeft++;
                    } else {
                        return list;
                    }
                    break;
                case UP:
                    if (y>boundUp+1) {
                        y--;
                    } else if (x<boundRight-1) {
                        x++;
                        direction = RIGHT;
                        boundUp++;
                    } else {
                        return list;
                    }
                    break;
            }
        }
         
        return list;
    }
}