import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {
    private List<String> combinations;
    private int index;

    // Constructor initializes the combinations and index
    public CombinationIterator(String characters, int combinationLength) {
        this.combinations = new ArrayList<>();
        this.index = 0;
        generateCombinations(characters, combinationLength, 0, new StringBuilder());
    }

    // Helper method to generate all combinations
    private void generateCombinations(String characters, int combinationLength, int start, StringBuilder current) {
        if (current.length() == combinationLength) {
            combinations.add(current.toString());
            return;
        }
        
        for (int i = start; i < characters.length(); i++) {
            current.append(characters.charAt(i));
            generateCombinations(characters, combinationLength, i + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }

    // Returns the next combination in lexicographical order
    public String next() {
        return combinations.get(index++);
    }

    // Returns true if there are more combinations available
    public boolean hasNext() {
        return index < combinations.size();
    }
}
