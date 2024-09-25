import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] heights = new int[rows][cols];
        
        // Convert matrix to heights matrix
        for (int i = 0; i < cols; i++) {
            heights[0][i] = matrix[0][i] == '1' ? 1 : 0;
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[i][j] = heights[i - 1][j] + 1;
                } else {
                    heights[i][j] = 0;
                }
            }
        }
        
        // Calculate maximum area for each row's histogram
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            maxArea = Math.max(maxArea, maxHistogramArea(heights[i]));
        }
        
        return maxArea;
    }
    
    private int maxHistogramArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;
        
        while (index < heights.length) {
            if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
                stack.push(index++);
            } else {
                int top = stack.pop();
                int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }

    // Driver code for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] matrix = {
            { '0', '1', '1', '0' },
            { '1', '1', '1', '1' },
            { '1', '1', '1', '1' },
            { '1', '1', '0', '0' },
        };
        System.out.println("Area of maximum rectangle is " + sol.maximalRectangle(matrix));
    }
}
