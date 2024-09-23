import java.util.*;

public class Solution {
    private static final Map<Character, String> digitToLetters = new HashMap<>();
    
    static {
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;//It first checks if the input digits is empty or null. If it is, it returns an empty list since there are no digits to process.
        }
        
        backtrack(result, digits, 0, new StringBuilder());
        return result;//If digits is not empty, it initializes an empty list result to store the combinations and calls the backtrack function to start generating combinations.
    }
    
    private void backtrack(List<String> result, String digits, int index, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;// If index equals the length of digits, it means we've built a complete combination (as long as the current index has reached the end of the digits string). This combination is then added to the result list.
        }
        
        String letters = digitToLetters.get(digits.charAt(index));
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(result, digits, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
