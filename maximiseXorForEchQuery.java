import java.util.Arrays;

class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {

        int n = nums.length;
        int maxK = (1 << maximumBit) - 1; // 2^maximumBit - 1
        int[] result = new int[n];

        // Calculate the initial XOR of all elements in nums
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }

        // Process each query
        for (int i = 0; i < n; i++) {
            // k is chosen as xorSum XOR maxK to maximize the result
            result[i] = xorSum ^ maxK;

            // Remove the last element from the current array (update xorSum)
            xorSum ^= nums[n - 1 - i];
        }

        return result;
    }

}
