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
        ListNode curr = head;
        for (int i = 0; i < index + 1; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    public void insertHead(int val) {
        addAtIndex(0, val);
    }

    public void insertTail(int val) {
        addAtIndex(length, val);
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

    private void addAtIndex(int index, int val) {
        if (index < 0 || index > length) {
            return;
        }
        ListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = curr.next;
        curr.next = newNode;
        length++;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode (int val) {
        this.val = val;
    }
}
