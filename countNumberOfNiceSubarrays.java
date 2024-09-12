public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int count = 0, left = 0, result = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) {
                k--;//If nums[right] is odd (nums[right] % 2 == 1), k is decremented. This keeps track of how many odd numbers are in the current window.
            }
            
            while (k < 0) {
                if (nums[left] % 2 == 1) {//If k becomes negative, it means the current window contains more than k odd numbers, so the window needs to be contracted from the left.
                    k++;
                }
                left++;//If nums[left] is odd, k is incremented to reflect the removal of an odd number from the window.
            }
            
            result += right - left + 1;//the number of subarrays ending at right is right - left + 1.
        }

        return result;
    }
}
