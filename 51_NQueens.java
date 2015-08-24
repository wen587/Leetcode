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

//BT
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<Integer> list = new ArrayList<>();
        helper(res, list, n);
        return res;
    }
    private List<String> draw(List<Integer> list) {
        List<String> cur = new ArrayList<String>();
        for(int i=0; i<list.size(); i++) {
            String res = "";
            for(int j=0; j<list.size(); j++) {
                if(j == list.get(i)) {
                    res += "Q";
                } else res += ".";
            }
            cur.add(res);
        }
        return cur;
        
    }
    private void helper(List<List<String>> res, List<Integer> list, int n) {
        if(list.size() == n) {
            // res.add(new ArrayList<String>(draw(list)));
            res.add(draw(list));
            return;
        }
        for(int i=0; i<n; i++) {
            if(!isValid(list, i)) continue;
            list.add(i);
            helper(res, list, n);
            list.remove(list.size() - 1);
        }
    }
    private boolean isValid(List<Integer> list, int col) {
        int row = list.size();
        for(int i=0; i<row; i++) {
            if(list.get(i) == col || i - list.get(i) == row - col || i + list.get(i) == row + col) return false;
        }
        return true;
    }
}

//终于攻克！！！！！！！也不错啊这方法
public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        int[] board = new int[n];
        placeQueenOnBoard(res, 0, board);
        return res;
    }

    public void placeQueenOnBoard(ArrayList<String[]> res, int row, int[] board) {
        int n = board.length;
        if(row == n) {
            String[] s = new String[n];
            for(int i = 0; i < n; i++) {
                s[i] = "";
                for(int j = 0; j < n; j++) 
                    s[i] += (j != board[i]) ? "." : "Q";
            }
            res.add(s);
        } else {
            for(int col = 0; col < n; col++) {
                if(isSafePlace(row, col, board)) {
                    board[row] = col;
                    placeQueenOnBoard(res, row + 1, board);
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



