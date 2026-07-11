class Solution {
    public boolean isValidSudoku(char[][] board) {

        int[] rowMask = new int[9];
        int[] colMask = new int[9];
        int[] boxMask = new int[9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.') {
                    continue;
                }

                int value = board[r][c] - '1';
                int bit = 1 << value;

                int box = (r / 3) * 3 + (c / 3);

                if ((rowMask[r] & bit) != 0) {
                    return false;
                }

                if ((colMask[c] & bit) != 0) {
                    return false;
                }

                if ((boxMask[box] & bit) != 0) {
                    return false;
                }

                rowMask[r] |= bit;
                colMask[c] |= bit;
                boxMask[box] |= bit;
            }
        }

        return true;
    }
}