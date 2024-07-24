class Solution {

    public void solve(char[][] board) {
        int ROWS = board.length;
        if (ROWS == 0) return;
        int COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O' && (r == 0 || c == 0 || r == ROWS - 1 || c == COLS - 1)) {
                    capture(board, r, c);
                }
            }
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void capture(char[][] board, int r, int c) {
        int ROWS = board.length;
        int COLS = board[0].length;

        if (r < 0 || c < 0 || r == ROWS || c == COLS || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        capture(board, r + 1, c);
        capture(board, r - 1, c);
        capture(board, r, c + 1);
        capture(board, r, c - 1);
    }
}
