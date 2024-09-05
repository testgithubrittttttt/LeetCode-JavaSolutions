class CustomStack {
    int[] arr;
    int size;
    int top;

    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        size = maxSize;
        top = -1; // Initialize top to -1 to indicate the stack is empty
    }
    
    public void push(int x) {
        if (top < size - 1) {
            top++;
            arr[top] = x;
        }
    }
    
    public int pop() {
        if (top >= 0) {
            int result = arr[top];
            top--;
            return result;
        }
        return -1; // Return -1 if the stack is empty
    }
    
    public void increment(int k, int val) {
        if (val == 0 || top == -1) return; // If the stack is empty or val is 0, return
        if (k > top + 1) k = top + 1; // If k is greater than the number of elements, adjust it
        for (int i = 0; i < k; i++) {
            arr[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k, val);
 */
