public class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;

        // Process the array in-place
        for (int i = n - 1; i > 0; i--) {//The outer loop iterates from the end of the array towards the beginning. This means that in each iteration, we are reducing the effective size of the array by one.
            for (int j = 0; j < i; j++) {//he inner loop updates each element in place. Instead of creating a new array, it directly modifies nums[j] to hold the result of (nums[j] + nums[j + 1]) % 10.
                nums[j] = (nums[j] + nums[j + 1]) % 10;
//Given nums = [1, 2, 3, 4, 5]:

// Initial Array: [1, 2, 3, 4, 5]

// First Iteration:

// Update nums: [ (1+2)%10, (2+3)%10, (3+4)%10, (4+5)%10, 5 ]
// Result: [3, 5, 7, 9, 5]
// Second Iteration:

// Update nums: [ (3+5)%10, (5+7)%10, (7+9)%10, 9, 5 ]
// Result: [8, 2, 6, 9, 5]
// Third Iteration:

// Update nums: [ (8+2)%10, (2+6)%10, 6, 9, 5 ]
// Result: [0, 8, 6, 9, 5]
// Fourth Iteration:

// Update nums: [ (0+8)%10, 8, 6, 9, 5 ]
// Result: [8, 8, 6, 9, 5]
            }
        }

        // The final result is the first element in the array
        return nums[0];
    }
}
