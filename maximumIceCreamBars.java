import java.util.Arrays;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int numberOfIceCreams = 0;
        Arrays.sort(costs);
        
        for (int i = 0; i < costs.length; i++) {
            if (costs[i] <= coins) {
                numberOfIceCreams++;
                coins -= costs[i];
            } else {
                break;  // If we can't afford this ice cream, no point in checking further as the array is sorted
            }
        }
        
        return numberOfIceCreams;
    }
}
