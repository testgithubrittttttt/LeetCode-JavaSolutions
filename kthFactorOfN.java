class Solution {
    public int kthFactor(int n, int k) {
        int[] arr = new int[n]; // Initialize an array to store factors,
        int m = 0; // Counter for number of factors found
        
        // Loop through all numbers from 1 to n
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) { // Check if i is a factor of n
                arr[m] = i; // If yes, store the factor in the array
                m++;  // Increment the counter for factors
            } 
            if(m == k) { // Check if we have found the k-th factor
                return arr[k-1]; // Return the k-th factor (1-based index, hence k-1 for 0-based array)
            }        
        }        
        return -1; // If k factors are not found, return -1 
    }
}