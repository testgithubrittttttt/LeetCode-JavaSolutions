import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FreqStack {
    private Map<Integer, Integer> freqMap; // frequency map of elements
    private Map<Integer, Stack<Integer>> groupStack; // stacks for each frequency
    private int maxFreq; // current maximum frequency

    public FreqStack() {
        freqMap = new HashMap<>();
        groupStack = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        // Update the frequency map
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);
        
        // Update the max frequency
        if (freq > maxFreq) {
            maxFreq = freq;
        }
        
        // Push the element onto the stack for the current frequency
        groupStack.computeIfAbsent(freq, k -> new Stack<>()).push(val);
    }

    public int pop() {
        // Pop the element from the stack that has the current maximum frequency
        int val = groupStack.get(maxFreq).pop();
        
        // Decrease the frequency of the popped element
        freqMap.put(val, freqMap.get(val) - 1);
        
        // If no elements are left at the current max frequency, decrease maxFreq
        if (groupStack.get(maxFreq).isEmpty()) {
            maxFreq--;
        }
        
        return val;
    }
}
