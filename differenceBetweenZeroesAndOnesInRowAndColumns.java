class Solution {
    public int[][] onesMinusZeros(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        
        int[] onesRow = new int[m];
        int[] zerosRow = new int[m];
        int[] onesCol = new int[n];
        int[] zerosCol = new int[n];
        
        // Count ones and zeros in each row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    onesRow[i]++;
                } else {
                    zerosRow[i]++;
                }
            }
        }
        
        // Count ones and zeros in each column
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    onesCol[j]++;
                } else {
                    zerosCol[j]++;
                }
            }
        }
        
        // Create the difference matrix
        int[][] diff = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
            }
        }
        
        return diff;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
            {1, 0, 1},
            {0, 1, 0},
            {1, 1, 0}
        };
        int[][] diff = solution.differenceMatrix(grid);
        for (int[] row : diff) {
            System.out.println(Arrays.toString(row));
        }
    }
}

 
