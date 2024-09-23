class Solution {
    
    // Helper function to expand around the center and find the longest palindromic substring
    private String expandAroundCenter(String s, int left, int right) {
        // Expand while the characters on both sides are the same
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the palindromic substring found
        return s.substring(left + 1, right);
    }
    
    // Main function to find the longest palindromic substring
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        String longest = ""; // Initialize an empty string to keep track of the longest palindrome found
        
        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes centered at s[i]
            String oddPalindrome = expandAroundCenter(s, i, i);
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }
            
            // Check for even-length palindromes centered between s[i] and s[i + 1]
            if (i < s.length() - 1) {
                String evenPalindrome = expandAroundCenter(s, i, i + 1);
                if (evenPalindrome.length() > longest.length()) {
                    longest = evenPalindrome;
                }
            }
        }
        
        return longest; // Return the longest palindromic substring found
    }
}