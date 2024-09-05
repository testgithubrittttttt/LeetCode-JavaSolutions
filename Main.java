class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false; // If the length is odd, it cannot be valid

        int open = 0, close = 0;
        int n = s.length();

        // First pass: Check from left to right
        //Ensure that at no point do we have more ) than (. If close exceeds open at any point, the string cannot be balanced by replacing any substring.
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                open++;
            } else {
                close++;
            }
            if (close > open) {
                return false;
            }
        }

        open = 0;
        close = 0;

        // Second pass: Check from right to left
        // Ensure that at no point do we have more () than ). If open exceeds close at any point, the string cannot be balanced by replacing any substring.
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                close++;
            } else {
                open++;
            }
            if (open > close) {
                return false;
            }
        }

        return true;
    }
}

// Example usage:
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canBeValid("())(()", "010011")); // Output: true
        System.out.println(sol.canBeValid("())", "000")); // Output: false
    }
}
