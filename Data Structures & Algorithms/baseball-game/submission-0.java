class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            String curr = operations[i];
            if (curr.equals("C")) {
                stack.pop();
            } else if (curr.equals("D")) {
                int a = stack.peek();
                stack.push(2 * a);
            } else if (curr.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(a + b);
            } else {
                stack.push(Integer.parseInt(curr));
            }
        }

        int sum = 0;
        for (int i = 0; i < stack.size(); i++) {
            sum += stack.get(i);
        }

        return sum;
    }
}