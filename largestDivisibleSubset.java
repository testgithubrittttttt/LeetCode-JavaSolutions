import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Edge case: if nums is empty, return an empty list
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        
        // Sort the array to make divisibility checks easier
        Arrays.sort(nums);
        
        int n = nums.length;
        int[] dp = new int[n];  // dp[i] will be the size of the largest subset ending with nums[i]
        int[] prev = new int[n];  // prev[i] will track the previous index in the subset
        Arrays.fill(dp, 1);  // Every element is at least a subset of size 1
        Arrays.fill(prev, -1);  // Initialize previous indices with -1
        
        int maxIndex = 0;  // Index of the largest element in the largest subset
        
        // Build the dp array and prev pointers
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            // Update the index of the maximum value in dp array
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        
        // Reconstruct the largest divisible subset
        List<Integer> answer = new ArrayList<>();
        while (maxIndex >= 0) {
            answer.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        
        // The answer is constructed in reverse order, so we need to reverse it
        Collections.reverse(answer);
        return answer;
    }
}
