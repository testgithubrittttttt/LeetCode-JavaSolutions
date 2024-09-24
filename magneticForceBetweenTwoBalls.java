import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1; // Minimum possible distance
        int right = position[position.length - 1] - position[0]; // Maximum possible distance
        
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (canPlaceBalls(position, m, mid)) {
                left = mid; // Try for a larger distance
            } else {
                right = mid - 1; // Reduce the distance
            }
        }
        return left;
    }

    private boolean canPlaceBalls(int[] position, int m, int distance) {
        int count = 1; // Place the first ball in the first basket
        int lastPosition = position[0];
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= distance) {
                count++;
                lastPosition = position[i];
                if (count == m) {
                    return true;
                }
            }
        }
        return false;
    }
}
