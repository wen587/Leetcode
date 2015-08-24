/*
 * The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard 
 * such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' 
 * placement, where 'Q' and '.' both indicate a queen and an empty space 
 * respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 
 */
// Follow up for N-Queens problem.

// Now, instead outputting board configurations, return the total number of distinct solutions.

//BT
public class Solution {
    public static int sum;
    public int totalNQueens(int n) {
        sum = 0;
        int[] board = new int[n];
        placeQueenOnBoard(0, board);
        return sum;
    }


    public void placeQueenOnBoard(int row, int[] board) {
        int n = board.length;
        if(row == n) {
            sum++;
            return;
        } else {
            for(int col = 0; col < n; col++) {
                if(isSafePlace(row, col, board)) {
                    board[row] = col;
                    placeQueenOnBoard(row + 1, board);
//                    board[row] = 0;//之和row前面的比，（第一行的直接true，第二行只跟第一行比）所以不需要
                }
            }
        }
    }

    public boolean isSafePlace(int row, int col, int[] board) {
        for(int i = 0; i < row; i++)
            if(board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row))
                return false;
        return true;
    }
}