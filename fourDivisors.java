class Solution {
    static int sum(int n)
    {
        int count=0;//counting the number of divisors
        int ans=0;//answer is for summing the number of divisors value
        for(int i=1;i<=n;i++)
        {
            if(n%i==0)//if divisible than we are increasing the count
            {
                count++;
                ans+=i;//here we are summing those values whom are divisible with the n value in array.
            }
            if(count>4)
            {
                return 0;
            }
        }
        if(count<4)return 0;
        return ans;
    }
    public int sumFourDivisors(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            ans+=sum(nums[i]);
        }
        return ans;
    }
}