class Solution {
    public int minAddToMakeValid(String s) {
        int open_needed = 0;
        int close_needed = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open_needed++;
            } else if (c == ')') {
                if (open_needed > 0) {
                    open_needed--;
                } else {
                    close_needed++;
                }
            }
        }

        return open_needed + close_needed;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minAddToMakeValid("())")); // Output: 1
        System.out.println(sol.minAddToMakeValid("(((")); // Output: 3
        System.out.println(sol.minAddToMakeValid("()"));  // Output: 0
        System.out.println(sol.minAddToMakeValid("()))((")); // Output: 4
    }
}

//or

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch==')'){
                if(!stack.isEmpty()&&stack.peek()=='('){
                    stack.pop();
                }
                else{
                    stack.push(ch);
                }
            }
            else{
                stack.push(ch);
            }

        }
        return stack.size();
    }
}
