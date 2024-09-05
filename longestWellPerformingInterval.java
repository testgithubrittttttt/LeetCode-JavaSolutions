class Solution {
    public int longestWPI(int[] hours) {
         // Transform hours to +1 for tiring days (>8 hours) and -1 for non-tiring days (<=8 hours)
        int[] transformed = new int[hours.length];
        for (int i = 0; i < hours.length; i++) {
            transformed[i] = hours[i] > 8 ? 1 : -1;
        }

        // Calculate prefix sums and use a hash map to store the first occurrence of each prefix sum
        Map<Integer, Integer> prefixSumIndices = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;
        
        for (int i = 0; i < transformed.length; i++) {
            prefixSum += transformed[i];
            
            if (prefixSum > 0) {
                maxLength = i + 1; // If prefix sum is positive, the interval from 0 to i is well-performing
            } else {
                if (!prefixSumIndices.containsKey(prefixSum)) {
                    prefixSumIndices.put(prefixSum, i);
                }
                
                // Check for a previous prefix sum that results in a positive balance
                if (prefixSumIndices.containsKey(prefixSum - 1)) {
                    maxLength = Math.max(maxLength, i - prefixSumIndices.get(prefixSum - 1));
                }
            }
        }

        return maxLength;
    }
}