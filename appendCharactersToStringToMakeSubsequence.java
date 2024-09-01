class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;
        int n = s.length(), m = t.length();

        // Traverse s and t to find the maximum matching prefix of t in s
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;  // Move to the next character in t if there's a match
            }
            i++;  // Always move to the next character in s
        }

        // The number of characters that need to be appended to s is
        // the remaining unmatched characters in t
        return m - j;
    }
}