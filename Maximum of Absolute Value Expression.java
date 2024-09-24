class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        //Initialize the maximum and minimum values for each of the four cases
        int max1 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE, min2 = Integer.MAX_VALUE;
        int max3 = Integer.MIN_VALUE, min3 = Integer.MAX_VALUE;
        int max4 = Integer.MIN_VALUE, min4 = Integer.MAX_VALUE;
        
        // Loop through the array to compute the expressions
        for (int i = 0; i < arr1.length; i++) {
            int expr1 = arr1[i] + arr2[i] + i;
            int expr2 = arr1[i] + arr2[i] - i;
            int expr3 = arr1[i] - arr2[i] + i;
            int expr4 = arr1[i] - arr2[i] - i;
            
            // Update the maximum and minimum values for each expression
            max1 = Math.max(max1, expr1);
            min1 = Math.min(min1, expr1);
            
            max2 = Math.max(max2, expr2);
            min2 = Math.min(min2, expr2);
            
            max3 = Math.max(max3, expr3);
            min3 = Math.min(min3, expr3);
            
            max4 = Math.max(max4, expr4);
            min4 = Math.min(min4, expr4);
        }
        
        // Calculate the maximum difference for each case
        int result1 = max1 - min1;
        int result2 = max2 - min2;
        int result3 = max3 - min3;
        int result4 = max4 - min4;
        
        // Return the maximum value among the four results
        return Math.max(Math.max(result1, result2), Math.max(result3, result4));
    }
}