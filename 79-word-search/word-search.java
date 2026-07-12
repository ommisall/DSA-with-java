class Solution {

    private int[] rowDir = {-1, 1, 0, 0};
    private int[] colDir = {0, 0, -1, 1};

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        int[] boardCount = new int[128];
        int[] wordCount = new int[128];

        for (char[] row : board) {
            for (char ch : row) {
                boardCount[ch]++;
            }
        }

        for (char ch : word.toCharArray()) {
            wordCount[ch]++;
            if (wordCount[ch] > boardCount[ch]) {
                return false;
            }
        }

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }

            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index, boolean[][] visited) {

        if (index == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return false;
        }

        if (visited[r][c] || board[r][c] != word.charAt(index)) {
            return false;
        }

        visited[r][c] = true;

        for (int k = 0; k < 4; k++) {
            if (dfs(board, word,
                    r + rowDir[k],
                    c + colDir[k],
                    index + 1,
                    visited)) {
                return true;
            }
        }

        visited[r][c] = false;

        return false;
    }
}