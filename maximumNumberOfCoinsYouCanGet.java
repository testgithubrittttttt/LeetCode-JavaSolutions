class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length / 3;
        int maxCoins = 0;
        
        // Pick every second largest pile from the sorted array
        for (int i = piles.length - 2; i >= n; i -= 2) {
            maxCoins += piles[i];
        }
        
        return maxCoins;
    }
}