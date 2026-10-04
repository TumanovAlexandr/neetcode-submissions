class LRUCache {

    Map<Integer,Node> nodes;
    int capacity;
    Node head;
    Node tail;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodes = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    } // TC: O(1), SC: O(1)
    
    public int get(int key) {
        if (nodes.containsKey(key)) {
            Node curr = nodes.get(key);
            remove(curr);
            append(curr);
            return curr.value;
        }
        return -1;
    } // TC: O(1), SC: O(1)
    
    public void put(int key, int value) {
        if (nodes.containsKey(key)) {
            Node curr = nodes.get(key);
            curr.value = value;
            remove(curr);
            append(curr);
        } else {
            if (size == capacity) {
                Node lru = head.next;
                remove(lru);
                nodes.remove(lru.key);
                size--;
            }

            Node newNode = new Node(key, value);
            nodes.put(key, newNode);
            append(newNode);
            size++;
        }
    } // TC: O(1), SC: O(n)

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    } // TC: O(1), SC: O(1)

    private void append(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    } // TC: O(1), SC: O(1)
}

class Node {

    Node next;
    Node prev;

    int key;
    int value;

    Node (int key, int value) {
        this.key = key;
        this.value = value;
    }
}
