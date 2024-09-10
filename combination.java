import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }

    private static void backtrack(int[] candidates, int remaining, List<Integer> combination, List<List<Integer>> result, int start) {
        // Base case: if remaining sum is 0, we found a valid combination
        if (remaining == 0) {
            result.add(new ArrayList<>(combination));
            return;
        // If remaining sum is less than 0, the current path is invalid
        } else if (remaining < 0) {
            return;
        }

        // Iterate through the candidates starting from 'start' to avoid duplicates
        for (int i = start; i < candidates.length; i++) {
            // Add the current candidate to the combination
            combination.add(candidates[i]);
            // Recursively call backtrack with the updated remaining sum and current combination
            backtrack(candidates, remaining - candidates[i], combination, result, i);
            // Remove the last added candidate (backtrack) to try the next candidate
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result); // Output: [[2, 2, 3], [7]]
    }
}
