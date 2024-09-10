class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // Minimum capacity of the ship is the max weight (at least one package)
        int maxWeight = 0;
        // Maximum capacity of the ship is the sum of all weights (ship all in one day)
        int totalWeight = 0;
        
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }
        
        int left = maxWeight;
        int right = totalWeight;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canShipInDays(weights, days, mid)) {
                right = mid; // Try for a smaller capacity
            } else {
                left = mid + 1; // Increase the capacity
            }
        }
        
        return left;
    }
    
    private boolean canShipInDays(int[] weights, int days, int capacity) {
        int currentWeight = 0;
        int requiredDays = 1;
        
        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                requiredDays++;
                currentWeight = 0;
            }
            currentWeight += weight;
        }
        
        return requiredDays <= days;
    }
}
