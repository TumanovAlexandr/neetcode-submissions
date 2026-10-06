class MyStack {

    Queue<Integer> first;
    Queue<Integer> second;

    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }
    
    public void push(int x) {
        while (!second.isEmpty()) {
            first.offer(second.poll());
        }
        second.offer(x);
        while (!first.isEmpty()) {
            second.offer(first.poll());
        }
    }
    
    public int pop() {
        return second.poll();
    }
    
    public int top() {
        return second.peek();
    }
    
    public boolean empty() {
        return second.isEmpty();
    }
}
/**
f []
s [2,1]

push(1)
push(2)
*/

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */