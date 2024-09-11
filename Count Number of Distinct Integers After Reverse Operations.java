// class Solution {
//     public int countDistinctIntegers(int[] nums) {
//         HashSet<Integer> set = new HashSet<>();
        
//         // Add original numbers to the set
//         for (int num : nums) {
//             set.add(num);
//         }
        
//         // Reverse digits and add reversed numbers to the set
//         for (int num : nums) {
//             int reversedNum = reverseDigits(num);
//             set.add(reversedNum);
//         }
        
//         // The size of the set gives us the number of distinct integers
//         return set.size();
//     }
    
//     // Helper method to reverse the digits of a number
//     private int reverseDigits(int num) {
//         int reversed = 0;
//         while (num > 0) {
//             reversed = reversed * 10 + (num % 10);
//             num /= 10;
//         }
//         return reversed;
//     }
// }
// class Solution {
//     public int countDistinctIntegers(int[] nums) {
//         Set<Integer> distinctIntegers = new HashSet<>();
//         for (int num : nums) {
//             distinctIntegers.add(num);
//             int reverseNum = Integer.parseInt(new StringBuilder().append(num).reverse().toString());
//             distinctIntegers.add(reverseNum);
//         }
//         return distinctIntegers.size();
//     }
// }
class Solution {
    public int countDistinctIntegers(int[] nums) {
        int count = 0;
        boolean[] fre = new boolean[1000001];//It is used to keep track of whether a particular number (or its reverse) has already been encountered.
        for(int i=0;i<nums.length;i++){
            if(!fre[nums[i]]){
                fre[nums[i]] = true;
                count++;
            }

            //The next part of the code is responsible for reversing the digits of the current number.
            
            int temp = nums[i];
            int rev = 0;
            while(temp!=0){
                int r = temp%10;
                rev = rev*10 + r;
                temp/=10;
            }
            //After reversing the digits of nums[i], we check if the reversed number rev has been encountered before using if (!fre[rev]).
            //If it hasn't been encountered, we mark it as true in fre and increment the count.
            //Finally, the count is returned, which gives the total number of distinct integers in the final array.
            if(!fre[rev]){
                fre[rev]=true;
                count++;
            }
        }
        
        return count;
    }
}