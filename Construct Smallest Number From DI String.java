class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder res = new StringBuilder(), stack = new StringBuilder();//StringBuilder is used to temporarily hold digits that will be processed to either form an increasing or decreasing sequence.
        for (int i = 0; i <= pattern.length(); i++) 
        {
            stack.append((char)('1' + i));
            // When i = 0, it adds '1' to the stack.
            // When i = 1, it adds '2' to the stack.
            if (i == pattern.length() || pattern.charAt(i) == 'I') 
            {//This condition checks if the current character in the pattern is 'I'. If it is, it means the sequence must now increase, so we process the digits accumulated in stack.
                res.append(stack.reverse());
                stack = new StringBuilder();
            }
        }
        return res.toString();
    }
}