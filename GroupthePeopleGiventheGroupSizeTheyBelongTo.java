import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // HashMap to store people by their group size
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        // List to store the final groups
        List<List<Integer>> result = new ArrayList<>();
        
        // Iterate through each person
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            
            // If the group size is not in the map, add it
            if (!map.containsKey(size)) {
                map.put(size, new ArrayList<>());
            }
            
            // Add the person to the group
            map.get(size).add(i);
            
            // If the group reaches its required size, add it to the result and reset the list
            if (map.get(size).size() == size) {
                result.add(new ArrayList<>(map.get(size)));
                map.get(size).clear();
            }
        }
        
        return result;
    }
}
