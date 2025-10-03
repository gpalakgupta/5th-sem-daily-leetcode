class Solution {
    int n;
    int m;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean ans = helper(board, word, i, j, 0);
                    if (ans) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int cr, int cc, int idx) {
        if (idx >= word.length()) {
            return true;
        }
        if (cr >= n || cc >= m || cr < 0 || cc < 0 || board[cr][cc] != word.charAt(idx)) {
            return false;
        }
        int[] r = { 0, -1, 0, 1 };
        int[] c = { -1, 0, 1, 0 };
        char ch = board[cr][cc];
        board[cr][cc] = '*';
        for (int i = 0; i < 4; i++) {
            int r1 = cr + r[i];
            int c1 = cc + c[i];
            boolean ans = helper(board, word, r1, c1, idx + 1);
            if (ans) {
                return ans;
            }
        }
        board[cr][cc] = ch;
        return false;
    }
}