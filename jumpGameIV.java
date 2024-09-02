class Solution {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];//stores maximum score you can achieve when reaching each index.
        dp[nums.length - 1] = nums[nums.length - 1];//because if you're at the last index, your score is simply the value of that element.
        int idx = nums.length - 1;//initially index is at last eleemnt and initially the array has 0 values except last last index have value.
        for (int i = nums.length - 2; i >= 0; i--) {
            if (idx > i + k) {// If idx is outside this range, it means we need to find a new idx within this range.
                idx = i + 1;
                for (int j = i + 2; j <= i + k && j <= nums.length - 1; j++) {
                    if (dp[j] > dp[idx]) {
                        idx = j;
                    }
                }
            }

            dp[i] = nums[i] + dp[idx];
            if (dp[i] > dp[idx]) {
                idx = i;
            }
        }
        return dp[0];
    }
}