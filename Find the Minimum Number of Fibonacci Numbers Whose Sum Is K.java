class Solution {   
   
    public int findMinFibonacciNumbers(int k) {    
       
        if (k < 2) return k;
        // This line checks if k is less than 2. If k is 1, it directly returns 1 because 1 itself is a Fibonacci number, and only one Fibonacci number (which is 1) is needed to sum up to 1.
        // If k is 0, it returns 0 because no Fibonacci number is needed to sum up to 0.
    
        int a = 1, b = 1;
        
        while (b <= k) { 
            b += a;//This updates b to the next Fibonacci number in the sequence.
            a = b - a;//This updates a to the previous value of b. By using these two lines, the variables a and b are always the last two Fibonacci numbers in the sequence.
        }

        return 1 + findMinFibonacciNumbers(k - a);
        // This line subtracts the largest Fibonacci number a from k and then recursively calls findMinFibonacciNumbers for the remaining value k - a.
        // The 1 + part accounts for the Fibonacci number a that was just used. The function then continues to find how many more Fibonacci numbers are needed to sum up the remaining value k - a.
    }
 }