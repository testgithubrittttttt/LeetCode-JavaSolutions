class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        // We use a stack to manage the numbers and the results of operations as we traverse the string. The stack helps keep track of values to be summed up later.
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;//This variable will be used to build the number as we parse through the string.
        char operation = '+'; // Initial operation is set to '+'.
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0'); // Build the number.
            }
            
            // If the current char is an operator or we've reached the end of the string.
            if (!Character.isDigit(currentChar) && currentChar != ' ' || i == s.length() - 1) {//This ensures that when an operator is encountered or we reach the end of the string, the previously built number is ready for processing.
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                
                operation = currentChar; // Update operation to the current one.
                currentNumber = 0; // Reset the current number.
            }
        }
        
        // Sum up the stack to get the result.
        int result = 0;
        for (int num : stack) {
            result += num;
        }
        
        return result;
    }
}