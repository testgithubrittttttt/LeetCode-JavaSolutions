import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recurse(res, 0, 0, "", n);
        return res;
    }
    
    // Helper function for recursion
    public void recurse(List<String> res, int left, int right, String s, int n) {
        // Base case: if the current string's length is equal to n * 2, add to result
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        
        // If the number of left parentheses is less than n, add a left parenthesis
        if (left < n) {
            recurse(res, left + 1, right, s + "(", n);
        }
        
        // If the number of right parentheses is less than the number of left parentheses, add a right parenthesis
        if (right < left) {
            recurse(res, left, right + 1, s + ")", n);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        List<String> result = solution.generateParenthesis(n);
        System.out.println(result); // Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
    }
}
