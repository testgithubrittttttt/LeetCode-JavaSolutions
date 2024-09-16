class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
       int N = rowSum.length;
        int M = colSum.length;

        int[][] origMatrix = new int[N][M];//This matrix will store the values that satisfy the row and column sums. Initially, all elements of origMatrix are set to 0 by default.
        int i = 0, j = 0;

        while (i < N && j < M) {
            origMatrix[i][j] = Math.min(rowSum[i], colSum[j]);//By choosing the minimum, the algorithm ensures that we can fully deplete at least one of the sums (either row or column) in this step.

            rowSum[i] -= origMatrix[i][j];//reduces the remaining sum needed for the current row
            colSum[j] -= origMatrix[i][j];//reduces the remaining sum needed for the current column

            if (rowSum[i] == 0) {
                i++;// after the subtraction, it means that the current row i has been fully filled to match the required sum. Therefore, increment i to move to the next row.
            } else {
                j++;//this implies that the column j has been filled to its required sum, so increment j to move to the next column.
            }
        }

        return origMatrix; 
    }
}