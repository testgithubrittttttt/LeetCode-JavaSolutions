class Solution {
    // Function to check if a character is a vowel
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int beautifulCount = 0;
        // Iterate over all possible substrings using two pointers
        for (int start = 0; start < n; start++) {
            int vowels = 0;
            int consonants = 0;
            for (int end = start; end < n; end++) {
                char c = s.charAt(end);
                if (isVowel(c)) {
                    vowels++;
                } else {
                    consonants++;
                }

                // Check if the substring is beautiful
                if (vowels == consonants && (vowels * consonants) % k == 0) {
                    beautifulCount++;
                }
            }
        }

        return beautifulCount;
    
    }
}


