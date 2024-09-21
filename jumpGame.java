class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {//starting from second last index because last toh goal he hai hmara
            if (i + nums[i] >= goal) {//If true, we are sure we can reach index 3 from index 2. We know that if we reach index 3, we can reach the last index, so update goal with index 2. In the next time, if we can reach index 2, that means we can reach the last index(= 4)
                goal = i;
            }
        }

        return goal == 0;        
    }
}