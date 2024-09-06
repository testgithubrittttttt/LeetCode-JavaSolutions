class Solution {
    public int minSwaps(String s) {
       if (s.length() == 0) {
            return 0;
        }
        
        int openBrackets = 0;
        int closeBrackets = 0;
        
        // Iterate through the string to count imbalances
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                openBrackets++;
            } else {
                if (openBrackets > 0) {
                    openBrackets--; // Match a closing bracket with an opening bracket
                } else {
                    closeBrackets++; // Unmatched closing bracket
                }
            }
        }
        
        // Number of swaps needed is half of the unmatched brackets (both open and close)
        return (closeBrackets + 1) / 2;
    }
}