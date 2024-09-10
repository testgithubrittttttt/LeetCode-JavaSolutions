// A subset of numbers can be used to obtain a sum of 1 by multiplying each number by some integer if and only if the greatest common divisor (GCD) of the entire set of numbers is 1. This is because if the GCD of the numbers is greater than 1, then all linear combinations of the numbers will also be multiples of this GCD, and hence it will be impossible to get a sum of 1.
class Solution {
    public boolean isGoodArray(int[] nums) {
        int tempGCD = nums[0];
        int i=0;
        while(i<nums.length){
            tempGCD=gcd(tempGCD , nums[i]);
            i++;
            if(tempGCD ==1 )return true;
        }
        return false;
    }

    int gcd(int a , int b){
        if(b==0)return a;
        else return gcd(b , (a%b));
    }
}