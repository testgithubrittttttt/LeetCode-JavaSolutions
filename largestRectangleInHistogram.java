import java.util.Stack;  // Import the Stack class from java.util package

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();  // Initialize a stack to keep track of indices of histogram bars
        int maxArea = 0;  // Variable to store the maximum area found
        int index = 0;  // Current index in the histogram
        while (index < heights.length) {  // Iterate through the histogram bars
            if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
                stack.push(index++);  // Push the current index to the stack if the stack is empty or the current bar is taller
            } else {
                int top = stack.pop();  // Pop from the stack if the current bar is shorter
                int height = heights[top];  // Get the height of the bar from the popped index
                int width = stack.isEmpty() ? index : index - stack.peek() - 1;  // Calculate the width
                int area = height * width;  // Calculate the area
                maxArea = Math.max(maxArea, area);  // Update maxArea if the current area is larger
            }
        }
        while (!stack.isEmpty()) {  // Process remaining bars in the stack
            int top = stack.pop();  // Pop the top index
            int height = heights[top];  // Get the height of the bar from the popped index
            int width = stack.isEmpty() ? index : index - stack.peek() - 1;  // Calculate the width
            int area = height * width;  // Calculate the area
            maxArea = Math.max(maxArea, area);  // Update maxArea if the current area is larger
        }
        
        return maxArea;  // Return the maximum area found
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};  // Example histogram heights
        System.out.println("Largest rectangle area is " + sol.largestRectangleArea(heights));  // Output the result
    }
}

