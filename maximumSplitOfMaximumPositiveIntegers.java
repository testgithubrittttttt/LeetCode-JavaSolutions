class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = new ArrayList<>();
        
        if (finalSum % 2 != 0) {
            return result; // If finalSum is odd, return an empty list
        }
        
        long currentEven = 2;
        long sum = 0;
        
        while (sum + currentEven <= finalSum) {
            result.add(currentEven);
            sum += currentEven;
            currentEven += 2;
        }
        
        // Adjust the last element if needed
        long lastElement = result.remove(result.size() - 1);
        result.add(finalSum - sum + lastElement);
        
        return result;
    }
}