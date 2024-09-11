class Solution {
    public int bitwiseComplement(int n) {
        // Convert the number to a binary string
        String binaryStr = Integer.toBinaryString(n);
        
        // Initialize the complement binary string
        StringBuilder complementStr = new StringBuilder();
        
        // Flip each bit
        for (char bit : binaryStr.toCharArray()) {
            if (bit == '0') {
                complementStr.append('1');
            } else {
                complementStr.append('0');
            }
        }
        
        // Convert the complement binary string back to an integer
        return Integer.parseInt(complementStr.toString(), 2);
    }
}