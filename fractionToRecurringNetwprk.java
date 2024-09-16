class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder result = new StringBuilder();
        
        // Handle the sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }
        
        // Convert to long to prevent overflow and work with positive values
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // Append the integer part
        result.append(num / den);
        long remainder = num % den;
        
        if (remainder == 0) {
            return result.toString();
        }
        
        // Append the decimal point
        result.append(".");
        
        // Map to store remainders and their positions
        Map<Long, Integer> remainderMap = new HashMap<>();
        
        while (remainder != 0) {
            // If the remainder is already seen, then there's a repeating fraction
            if (remainderMap.containsKey(remainder)) {
                int index = remainderMap.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }
            
            // Store the remainder with its corresponding index in the result
            remainderMap.put(remainder, result.length());
            
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }
        
        return result.toString();
    }
}