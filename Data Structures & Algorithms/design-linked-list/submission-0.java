class MyLinkedList {

    int length;
    ListNode head;
    ListNode tail;

    public MyLinkedList() {
        length = 0;
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
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
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        ListNode next = head.next;
        ListNode prev = head;
        prev.next = newNode;
        next.prev = newNode;
        newNode.next = next;
        newNode.prev = prev;
        length++;
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode next = tail;
        ListNode prev = tail.prev;
        prev.next = newNode;
        next.prev = newNode;
        newNode.next = next;
        newNode.prev = prev;
        length++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) {
            return;
        }

        ListNode curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        ListNode newNode = new ListNode(val);
        ListNode next = curr;
        ListNode prev = curr.prev;
        prev.next = newNode;
        next.prev = newNode;
        newNode.next = next;
        newNode.prev = prev;
        length++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }

        ListNode curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        ListNode next = curr.next;
        ListNode prev = curr.prev;
        prev.next = next;
        next.prev = prev;
        length--;
    }
}

class ListNode {
    
    int val;
    ListNode prev;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */