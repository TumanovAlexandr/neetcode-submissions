class Deque {

    Node head;
    Node tail;
    int size;

    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void append(int value) {
       Node newNode = new Node(value);
       if (head == null) {
        head = newNode;
        tail = newNode;
        size++;
        return;
       }
       tail.next = newNode;
       newNode.prev = tail;
       tail = newNode;
       size++;
    }

    public void appendleft(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public int pop() {
        if (tail == null) {
            return -1;
        }
        int val = tail.val;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node prev = tail.prev;
            prev.next = null;
            tail = prev; 
        }
        size--;
        return val;
    }

    public int popleft() {
        if (head == null) {
            return -1;
        }
        int val = head.val;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return val;
    }
}

class Node {
    int val;
    Node next;
    Node prev;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}