// Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

// A region is captured by flipping all 'O's into 'X's in that surrounded region.

// For example,
// X X X X
// X O O X
// X X O X
// X O X X
// After running your function, the board should be:

// X X X X
// X X X X
// X X X X
// X O X X


public class Solution {
    Queue<Integer> queue;
    public void solve(char[][] board) {
        if(board.length < 1) return;
        queue = new LinkedList<>();
        int row = board.length;
        int col = board[0].length;
        for(int i=0; i<row; i++) {
            enqueue(board, i, 0);
            enqueue(board, i, col - 1);
        }
        for(int j=1; j<col-1; j++) {
            enqueue(board, 0, j);
            enqueue(board, row - 1, j);
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / col;
            int y = cur % col;
            // if(board[x][y] == 'O') {
            //     board[x][y] = '#';
            // }
            enqueue(board, x - 1, y);
            enqueue(board, x + 1, y);
            enqueue(board, x, y - 1);
            enqueue(board, x, y + 1);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '#') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    public void enqueue(char[][] board, int x, int y) {
        if(x <0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O') {
            return;
        }
        queue.offer(x * board[0].length + y);
        board[x][y] = '#';
    }
}