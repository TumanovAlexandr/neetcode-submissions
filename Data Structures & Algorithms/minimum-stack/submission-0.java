class MinStack {

    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int value) {
        if (!stack.isEmpty()) {
            int[] curr = stack.peek();
            int minVal = Math.min(curr[1], value);
            stack.push(new int[] {value, minVal});
        } else {
            stack.push(new int[] {value, value});
        }
    } // TC: O(1), SC: O(1)
    
    public void pop() {
        stack.pop();
    } // TC: O(1), SC: O(1)
    
    public int top() {
        return stack.peek()[0];
    } // TC: O(1), SC: O(1)
    
    public int getMin() {
        if (!stack.isEmpty()) {
            return stack.peek()[1];
        }
        return 0;
    } // TC: O(1), SC: O(1)
}
