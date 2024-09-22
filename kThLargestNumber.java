import java.util.Arrays;

public class Solution {
    public String kthLargestNumber(final String[] nums, int k) {
        // Sort the array using a custom comparator
        Arrays.sort(nums, (a, b) -> compare(a, b));

        // Return the k-th largest number
        return nums[nums.length - k];
    }

    private int compare(final String num1, final String num2) {
        // Compare based on length of strings
        if (num1.length() != num2.length()) {
            return Integer.compare(num2.length(), num1.length());
        }

        // If lengths are equal, compare lexicographically
        return num2.compareTo(num1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] nums = {"3", "6", "2", "10", "20"};
        int k = 2;
        String result = solution.kthLargestNumber(nums, k);
        System.out.println(result); // Output: "10"
    }
}
