/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        for (int i = 1; i < lists.length; i++) {
            ListNode curr = merge(lists[i], lists[i - 1]); 
            lists[i] = curr;
        }
        return lists[lists.length - 1];
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }

        if (first != null) {
            curr.next = first;
        }
        if (second != null) {
            curr.next = second;
        }
        return dummy.next;
    }
}
/**
TC: O(n * k), SC: O(1)
*/