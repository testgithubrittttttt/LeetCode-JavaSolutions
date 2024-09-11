class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        // Parse the real and imaginary parts of the first complex number
        String[] parts1 = num1.split("\\+|i");
        int real1 = Integer.parseInt(parts1[0]);
        int imaginary1 = Integer.parseInt(parts1[1]);

        // Parse the real and imaginary parts of the second complex number
        String[] parts2 = num2.split("\\+|i");
        int real2 = Integer.parseInt(parts2[0]);
        int imaginary2 = Integer.parseInt(parts2[1]);

        // Calculate the real part of the product
        int realPart = real1 * real2 - imaginary1 * imaginary2;

        // Calculate the imaginary part of the product
        int imaginaryPart = real1 * imaginary2 + imaginary1 * real2;

        // Return the result as a string
        return realPart + "+" + imaginaryPart + "i";
    }
}