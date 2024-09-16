import java.util.Scanner;

public class fireflyQueries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int n = scanner.nextInt(); // Length of array
            int q = scanner.nextInt(); // Number of queries
            int[] a = new int[n];
            long[] prefixSum = new long[n + 1]; // Prefix sum array for a
            
            // Read the array a and compute prefix sums
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                prefixSum[i + 1] = prefixSum[i] + a[i];
            }
            
            // Process each query
            for (int i = 0; i < q; i++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                
                // Compute the sum for the range [l, r] in the concatenated array b
                long sum = 0;
                
                // Convert 1-based index l and r to 0-based for easier calculations
                l--; r--;
                
                int startShift = l / n; // Determine the starting cyclic shift
                int startPos = l % n;   // Determine the position within the cyclic shift
                
                int endShift = r / n;   // Determine the ending cyclic shift
                int endPos = r % n;     // Determine the position within the cyclic shift
                
                if (startShift == endShift) {
                    // If both l and r are within the same cyclic shift
                    sum = prefixSum[endPos + 1] - prefixSum[startPos];
                } else {
                    // Sum elements from startPos to the end of the startShift
                    sum += prefixSum[n] - prefixSum[startPos];
                    
                    // Sum entire shifts between startShift + 1 and endShift - 1
                    for (int shift = startShift + 1; shift < endShift; shift++) {
                        sum += prefixSum[n];
                    }
                    
                    // Sum elements from the beginning of the endShift to endPos
                    sum += prefixSum[endPos + 1];
                }
                
                System.out.println(sum);
            }
        }
        
        scanner.close();
    }
}
