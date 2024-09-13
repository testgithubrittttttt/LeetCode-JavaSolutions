class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        
        dp[0] = 1; // There's one way to decode an empty string
        dp[1] = 1; // The first character can be decoded if it's not '0'

        for (int i = 2; i <= n; i++) {
            // Check the last one digit
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Check the last two digits
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}