class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;  // 1 + 1 = 2, product = 1
        if (n == 3) return 2;  // 1 + 2 = 3, product = 2

        int product = 1;

        while (n > 4) {
            product *= 3;
            n -= 3;
        }

        // Now n is either 4 or less
        return product * n;
    }
}
