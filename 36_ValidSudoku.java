/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<Character>();
        for(int i=0; i<board.length; i++) {
            set.clear();
            for(int j=0; j<board.length; j++) {
                if(board[i][j] != '.' && !set.add(board[i][j]))
                    return false;
            }
        }
        for(int j=0; j<board.length; j++) {
            set.clear();
            for(int i=0; i<board.length; i++) {
                if(board[i][j] != '.' && !set.add(board[i][j]))
                    return false;
            }
        }
        int totalBox = board.length / 3;
        for(int p=0; p<totalBox; p++) {
            for(int q=0; q<totalBox; q++) {
                set.clear();
                for(int i=p * 3; i<p * 3 + 3; i++) {
                    for(int j=q * 3; j<q * 3 + 3; j++) {
                        if(board[i][j] != '.' && !set.add(board[i][j]))
                            return false;
                    }
                }
            }
        }
        return true;
    }
}