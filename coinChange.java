import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Create a dp array of size amount + 1
        int[] dp = new int[amount + 1];
        // Initialize the dp array with a large number
        Arrays.fill(dp, amount + 1);
        // Base case: 0 coins are needed to make the amount 0
        dp[0] = 0;

        // Iterate through all amounts from 1 to amount
        for (int i = 1; i <= amount; i++) {
            // For each amount, iterate through all coin denominations
            for (int coin : coins) {
                // If the coin can be used to make the current amount
                if (i - coin >= 0) {
                    // Update the dp value
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still a large number, return -1 (impossible to make the amount)
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(solution.coinChange(coins, amount)); // Output: 3

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println(solution.coinChange(coins2, amount2)); // Output: -1
    }
}
