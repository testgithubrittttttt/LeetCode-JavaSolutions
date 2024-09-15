class Solution {
    //The power of Cantor's diagonalization comes from its ability to guarantee uniqueness and non-existence in a constructive manner. Instead of guessing or checking each possible string against the given set, diagonalization provides a systematic way to construct a unique entity directly. This makes it a preferred choice in problems where the goal is to ensure a constructed object does not overlap with a predefined set.
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            // Flip the i-th character of the i-th string in nums
            char ch = nums[i].charAt(i);
            result.append(ch == '0' ? '1' : '0');
        }

        return result.toString();
    }

}

