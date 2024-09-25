//The sliding window technique is effective for problems involving contiguous subarrays or subsequences of fixed size. Here, we need to find the maximum sum of k cards, and these cards can be taken from either end of the array.
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        // Calculate the sum of the first k cards
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += cardPoints[i];
        }
        
        int maxScore = currentSum;
        
        // Use a sliding window to consider other combinations
        for (int i = 0; i < k; i++) {
            currentSum = currentSum - cardPoints[k - 1 - i] + cardPoints[n - 1 - i];
            maxScore = Math.max(maxScore, currentSum);
        }
        
        return maxScore;
    }
}
