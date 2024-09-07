package stack;

import java.util.Stack;

public class reverseStack {
    public static void reverseStack(Stack<Integer> stack) {
        Stack<Integer> auxiliaryStack = new Stack<>();
        
        // Pop all elements from the original stack and push them into the auxiliary stack
        while (!stack.isEmpty()) {
            auxiliaryStack.push(stack.pop());
        }
        
        // Pop all elements from the auxiliary stack and push them back into the original stack
        while (!auxiliaryStack.isEmpty()) {
            stack.push(auxiliaryStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);
        reverseStack(stack);
        System.out.println("Reversed Stack: " + stack);
    }
}
