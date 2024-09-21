class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0; // If there's only one element, we're already at the last index
        }
        
        int jumps = 0; // Number of jumps made
        int currentEnd = 0; // The end of the range that the current jump can reach
        int farthest = 0; // The farthest point that all the jumps can reach so far

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]); // Update the farthest point
            
            // If we have reached the end of the range that the current jump can reach
            if (i == currentEnd) {
                jumps++; // Make a jump
                currentEnd = farthest; // Update the end of the range for the next jump
                
                // If we have already reached or passed the last index
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
