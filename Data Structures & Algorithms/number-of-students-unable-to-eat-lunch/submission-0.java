class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < students.length; i++) {
            queue.offer(students[i]);
        }

        int res = n;
        for (int i = 0; i < sandwiches.length; i++) {
            int cnt = 0;
            while (cnt < n && sandwiches[i] != queue.peek()) {
                queue.offer(queue.poll());
                cnt++;
            }
            if (queue.peek() == sandwiches[i]) {
                queue.poll();
                res--;
            } else {
                break;
            }
        }
        return res;
    }
}
/**
queue
[]   
stack
[0,1,0,1]
         ^i


TC: O(n), SC: O(n)
*/