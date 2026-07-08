class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows)
            return s;

        int n = s.length();

        char[][] grid = new char[numRows][n];

        int row = 0;
        int col = 0;
        int index = 0;

        while (index < n) {

           
            while (row < numRows && index < n) {
                grid[row][col] = s.charAt(index++);
                row++;
            }

            row -= 2;
            col++;

            
            while (row > 0 && index < n) {
                grid[row][col] = s.charAt(index++);
                row--;
                col++;
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '\0') {
                    ans.append(grid[i][j]);
                }
            }
        }

        return ans.toString();
    }
}