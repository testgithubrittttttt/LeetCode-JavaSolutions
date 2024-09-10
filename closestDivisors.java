//The problem requires us to find two integers whose product is either num + 1 or num + 2 and whose absolute difference is the smallest.
//We need to find two integers a and b such that:
// a * b = num + 1 or a * b = num + 2
// The absolute difference |a - b| is minimized.
// The problem asks us to return these two integers in any order.
class Solution {
    public int[] closestDivisors(int num) {
        // Try num + 1 and num + 2
        int[] result1 = findClosestDivisors(num + 1);
        int[] result2 = findClosestDivisors(num + 2);

        // Compare the absolute differences
        if (Math.abs(result1[0] - result1[1]) < Math.abs(result2[0] - result2[1])) {
            return result1;
        } else {
            return result2;
        }
    }

    private int[] findClosestDivisors(int num) {//The function returns the pair with the smallest absolute difference by comparing the results for num + 1 and num + 2.
        for (int i = (int) Math.sqrt(num); i >= 1; i--) {
            if (num % i == 0) {
                int a = i;
                int b = num / i;
                return new int[]{a, b};
            }
        } //TC = O ROOT(N)
        return new int[]{1, num}; // fallback, should not be needed in theory
    }
}
