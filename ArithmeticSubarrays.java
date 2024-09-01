import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();//store the results for each query.
        
        for (int i = 0; i < l.length; i++) {//l and r koi sa bhi choose karlo because both have same lengths
            int start = l[i];
            int end = r[i];
            
            int[] subarray = Arrays.copyOfRange(nums, start, end + 1);
            Arrays.sort(subarray);//orting is essential because an arithmetic sequence requires consistent differences between consecutive element
            
            boolean isArithmetic = true;
            int difference = subarray[1] - subarray[0];//not happeng then false
            
            for (int j = 1; j < subarray.length - 1; j++) {
                if (subarray[j + 1] - subarray[j] != difference) {
                    isArithmetic = false;
                    break;
                }
            }
            
            result.add(isArithmetic);//After checking the current subarray, we add the value of isArithmetic to the result list.
        }
        
        return result;
    }
}