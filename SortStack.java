import java.util.Stack;

public class SortStack {
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> auxiliaryStack = new Stack<>();//eske ander push karenge sorted stack ko or baad mai voh he elements vapi original stack mai dalenge
        
        while (!stack.isEmpty()) {
            int temp = stack.pop();//joh abhi abhi nikla hai
            
            // While auxiliary stack is not empty and top of auxiliary stack is greater than temp
            while (!auxiliaryStack.isEmpty() && auxiliaryStack.peek() > temp) {
                stack.push(auxiliaryStack.pop());
            }
            
            // Push the current element to the auxiliary stack
            auxiliaryStack.push(temp);
        }
        
        // Transfer the sorted elements back to the original stack
        while (!auxiliaryStack.isEmpty()) {
            stack.push(auxiliaryStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
