class BrowserHistory {

    ListNode curr;

    public BrowserHistory(String homepage) {
        curr = new ListNode(homepage);
    }
    
    public void visit(String url) {
        ListNode newNode = new ListNode(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;
    }
    
    public String back(int steps) {
        while (curr.prev != null && steps > 0) {
            curr = curr.prev;
            steps--;
        }
        return curr.val;
    }
    
    public String forward(int steps) {
        while (curr.next != null && steps > 0) {
            curr = curr.next;
            steps--;
        }
        return curr.val;
    }
}

class ListNode {
    String val;
    ListNode next;
    ListNode prev;

    ListNode(String val) {
        this.val = val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */