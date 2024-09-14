class Solution {
    public String convertToTitle(int columnNumber) {
                StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            // Decrement columnNumber by 1 to convert to 0-based index
            columnNumber--;
            
            // Find the remainder when columnNumber is divided by 26
            int remainder = columnNumber % 26;
            
            // Convert remainder to corresponding character
            char ch = (char) (remainder + 'A');
            
            // Append character to result
            result.append(ch);
            
            // Update columnNumber for next iteration
            columnNumber /= 26;
        }

        // Since the result is constructed in reverse order, reverse it before returning
        return result.reverse().toString();
    }
}