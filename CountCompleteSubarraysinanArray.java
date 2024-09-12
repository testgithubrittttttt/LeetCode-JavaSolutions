import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> freq = new HashSet<>();
        
        // Count the distinct elements in the array
        for (int i = 0; i < n; i++) {
            freq.add(nums[i]);
        }
        
        int distinct = freq.size();
        int ans = 0;
    
        // Iterate through all possible subarrays
        for (int i = 0; i < n; i++) {
            Set<Integer> temp = new HashSet<>();
            
            for (int j = i; j < n; j++) {
                temp.add(nums[j]);
                if (temp.size() == distinct) {
                    ans++;
                }
            }
        }
        
        return ans;   
    }
}
