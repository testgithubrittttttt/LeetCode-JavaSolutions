class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        int x = 1;
        int y = 1000; // Upper limit for search, as all integers are positive.

        while (x <= 1000 && y > 0) {
            int value = customfunction.f(x, y);
            if (value == z) {
                // Found a valid pair (x, y)
                result.add(Arrays.asList(x, y));
                // Move x right to find more possible pairs
                x++;
            } else if (value < z) {
                // Increase x to get closer to z
                x++;
            } else {
                // Decrease y to get closer to z
                y--;
            }
        }

        return result;
    }
}
