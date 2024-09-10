class Solution {
    public static int climbStairs(int n) {
        // Base cases
        if (n == 0)
            return 1; // There's one way to stay at the ground (doing nothing)
        if (n == 1)
            return 1; // There's one way to climb one step (one 1-step move)

        // Create an array to store the number of ways to reach each step
        int[] ways = new int[n + 1];
        ways[0] = 1; // One way to reach step 0
        ways[1] = 1; // One way to reach step 1

        // Fill the array using the recurrence relation
        for (int i = 2; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];//eska matlab ya toh ek step lega ya 2 step lega
        }

        return ways[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Number of ways to climb " + n + " steps: " + climbStairs(n));
    }
}
