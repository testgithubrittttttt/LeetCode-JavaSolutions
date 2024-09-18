class Solution {
    public String stringHash(String s, int k) {
        int n = s.length();
        StringBuilder result = new StringBuilder();

        // Process each substring of length k
        for (int i = 0; i < n; i += k) {
            String substring = s.substring(i, i + k);
            int hashSum = 0;

            // Calculate hash sum for the substring
            for (char c : substring.toCharArray()) {
                hashSum += c - 'a';  // Compute hash value (index in the alphabet)
            }

            // Calculate the hashed character's index
            int hashedCharIndex = hashSum % 26;

            // Get the corresponding character
            char hashedChar = (char) (hashedCharIndex + 'a');

            // Append to the result
            result.append(hashedChar);
        }

        return result.toString();
    }
}