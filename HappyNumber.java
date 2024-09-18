// class Solution {
//     // Helper function to compute the sum of the squares of the digits of n
//     private static int getSumOfSquares(int n) {
//         int sum = 0;
//         while (n > 0) {
//             int digit = n % 10; // Get the last digit
//             sum += digit * digit; // Add the square of the digit to sum
//             n /= 10; // Remove the last digit
//         }
//         return sum;
//     }

//     public static boolean isHappy(int n) {
//         Set<Integer> seenNumbers = new HashSet<>(); // To track numbers that we have seen

//         // Repeat the process until n becomes 1 or a cycle is detected
//         while (n != 1 && !seenNumbers.contains(n)) {
//             seenNumbers.add(n); // Add the current number to the set
//             n = getSumOfSquares(n); // Replace n with the sum of the squares of its digits
//         }

//         return n == 1;
//     }
// }
class Solution {
    public boolean isHappy(int n) {
        int num = n;
        while(n>9){//If a number is less than or equal to 9, then its square sum is the number itself (n^2). The loop breaks down numbers with more than one digit into a single-digit number by continually computing the sum of the squares of its digits until n becomes a single-digit number.
            int x = 0;//sum of squares of all the digits of n during the inner loop iteration.
            while(n!=0){
                int a = n%10;
                n/=10;
                x += (a*a);
            }
            n=x;//This prepares n for the next iteration of the outer loop. If n is still greater than 9, the loop will run again. If n becomes a single digit, the loop will exit.
        }
        if(n==1 || n==7){//it is also considered a happy number because, in base 10, 7 is part of a cycle that leads to 1. For example, if you start from 7, the process leads to 49 -> 97 -> 130 -> 10 -> 1.
            return true;
        }
        return false;
    }
}