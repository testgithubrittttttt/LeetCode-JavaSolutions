// Approach:

// The approach used in the increasingTriplet function is based on keeping track of two minimum values, a and b, while iterating through the array. Here's a step-by-step explanation:

// Initialize two variables, a and b, to INT_MAX.
// Iterate through the array, and for each element:
// If the element is less than or equal to a, update a with the element.
// If the element is greater than a but less than or equal to b, update b with the element.
// If the element is greater than both a and b, it means an increasing triplet is found, and the function returns true.
// If the loop completes without finding an increasing triplet, return false.

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num <= a) {
                a = num;//yha se pta chala ki chalo ek number toh bda hai
            } else if (num <= b) {
                b = num;//yha se pta lga ek or number bda hai
            } else {
                return true;//yha se ek or milla joh phele vallo se bhi bda hai.
            }
        }
        
        return false;//no triplet
    }
}

//or

class Solution {
    public:
        bool increasingTriplet(vector<int>& nums) 
        {
            int first_small = INT_MAX;
            int second_small = INT_MAX;
            for(int i=0;i<nums.size();i++)
            {
                if(nums[i]<=first_small)
                    first_small=nums[i];
                else if( nums[i]<= second_small )
                    second_small= nums[i];
                else
                    return true;
            }
            return false;
        }
    };