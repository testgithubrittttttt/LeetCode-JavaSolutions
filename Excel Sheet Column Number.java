class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;  // Initialize result to store column number

        // Iterate over each character in the string
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);  // Get the current character
            int value = c - 'A' + 1;  // Convert character to its corresponding value (A=1, B=2, ..., Z=26)
            result = result * 26 + value;  // Update result for base-26 system
        }

        return result;  // Return the final column number
    }
}