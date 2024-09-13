import java.util.Arrays;

public class Solution {
    public boolean closeStrings(String word1, String word2) {
        // If the lengths of the words are different, they can't be close
        if (word1.length() != word2.length()) {
            return false; // from this part our case 2 runs.
        }

        // Count the frequency of each character in both words
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }

        // Check if both words have the same set of characters
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {//If either of the conditions in the if statement is true, it means that word1 and word2 do not have the same set of characters.
                return false;
            }
        }

        // Check if both words have the same frequency distribution
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);//here we are checking the equality of the two strings
    
}
    
}
