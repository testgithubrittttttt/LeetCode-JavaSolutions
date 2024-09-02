import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        // Initialize the deque to store indices of prefix sums
        Deque<Integer> deque = new LinkedList<>();
        // Initialize the prefix sum array
        long[] prefixSum = new long[nums.length + 1];
        // Variable to track the minimum length of the subarray found
        int minLength = Integer.MAX_VALUE;

        // Calculate prefix sums
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Iterate through the prefix sums
        for (int i = 0; i <= nums.length; i++) {
            // Check if a valid subarray is found
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            // Maintain the deque with potential starting points
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            // Append the current index to the deque
            deque.addLast(i);
        }

        // Return the minimum length if found, otherwise return -1
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

}
