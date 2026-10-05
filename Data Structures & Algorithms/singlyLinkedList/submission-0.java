class LinkedList {

    int length;
    ListNode head;
    ListNode tail;

    public LinkedList() {
        this.length = 0;
        head = new ListNode(-1);
        tail = head;
    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        ListNode curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        if (length == 0) {
            tail = newNode;
        }
        length++;
    }

    public void insertTail(int val) {
        ListNode newNode = new ListNode(val);
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= length) {
            return false;
        }
        ListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        if (curr.next == tail) {
            tail = curr;
        }

        curr.next = curr.next.next;
        length--;

        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode curr = head.next;
        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }

        return arr;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode (int val) {
        this.val = val;
    }
}
