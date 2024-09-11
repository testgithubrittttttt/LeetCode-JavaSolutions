class Solution {
    public String baseNeg2(int n) {
        if (n == 0) return "0";//If the input n is 0, the function immediately returns the string "0". This is because the binary representation of 0 in any base is always "0".
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            int ost = n % -2;//ost is the remainder when n is divided by -2. This remainder represents the current binary digit in base -2.
            n /= -2;//n is then divided by -2 to update n for the next iteration. This gives the quotient, which will be used in the next step to determine the next digit.
            if (ost < 0) {
                ost += 2;
                n += 1;//Since the base is negative, remainders can be negative. If ost is negative, we need to adjust it:
                       //We add 2 to ost to make it non-negative.
                       //We also increment n by 1 to ensure the quotient is correctly adjusted for the next iteration.
            }
            sb.append(ost);
        }

        return sb.reverse().toString();
    }
}