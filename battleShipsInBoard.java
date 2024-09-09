class Solution {
    public int countBattleships(char[][] board) {
                if (board == null || board.length == 0) {
            return 0;
        }

        int rows = board.length;
        int cols = board[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X') {
                    // Check if the cell is the start of a new battleship
                    if ((i == 0 || board[i-1][j] == '.') && (j == 0 || board[i][j-1] == '.')) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}