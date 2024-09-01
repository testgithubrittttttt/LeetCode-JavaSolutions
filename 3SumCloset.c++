#include <vector>
#include <algorithm>
#include <climits>

class Solution {
public:
    int threeSumClosest(std::vector<int>& nums, int target) {
        std::sort(nums.begin(), nums.end()); // Sort the array
        int closest_sum = INT_MAX / 2;  // Initialize to a large value
        
        // Iterate through the array with a fixed pointer
        for (int i = 0; i < nums.size() - 2; ++i) {
            int left = i + 1, right = nums.size() - 1; // Two pointers
            
            // Use two-pointer technique to find the closest sum
            while (left < right) {
                int current_sum = nums[i] + nums[left] + nums[right];
                
                // Update closest_sum if the current sum is closer to the target
                if (std::abs(current_sum - target) < std::abs(closest_sum - target)) {
                    closest_sum = current_sum;
                }
                
                // Adjust pointers based on the comparison with target
                if (current_sum < target) {
                    ++left; // Move left pointer to the right to increase the sum
                } else if (current_sum > target) {
                    --right; // Move right pointer to the left to decrease the sum
                } else {
                    return current_sum; // Exact match found
                }
            }
        }
        
        return closest_sum; // Return the closest sum found
    }
};
