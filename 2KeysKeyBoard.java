class Solution {
    public int minSteps(int n) {
        if (n == 1) return 0;
        
        int steps = 0;
        int factor = 2;
//      The strategy is to decompose n into its prime factors. Each time you find a factor f, it implies that you can reach n by first getting n/f 'A's and then performing f operations to reach n.
//      Example:
//      For n = 18:
//      18 can be factorized as 2 * 3 * 3.
//      The solution approach is to repeatedly divide n by its smallest factor and add that factor to the total number of steps required.

        while (n > 1) {
            while (n % factor == 0) {
                steps += factor; // Add the factor to steps as it represents the number of operations
                n /= factor;     // Reduce n by dividing it by the current factor
            }
            factor++; // Move to the next factor
        }
        
        return steps;
    }
}
