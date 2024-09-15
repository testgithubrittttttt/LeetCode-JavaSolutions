class Solution {
    public long[] sumOfThree(long num) {
        // Check if num can be expressed as the sum of three consecutive integers
        if (num % 3 != 0) {
            return new long[0]; // return empty array if num is not divisible by 3
        }
        
        // Calculate the middle integer
        long x = num / 3;
        
        // Return the three consecutive integers
        return new long[]{x - 1, x, x + 1};
    }
}
