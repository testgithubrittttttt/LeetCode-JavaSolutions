class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Create a DP table
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize the first row and first column
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Deleting all characters from word1 to match an empty word2
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Inserting all characters from word2 into an empty word1
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // No operation needed
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j],    // Deletion
                                        Math.min(dp[i][j - 1],    // Insertion
                                                 dp[i - 1][j - 1])) + 1; // Replacement
                }
            }
        }
        
        return dp[m][n];
    }
}