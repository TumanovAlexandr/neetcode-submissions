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
        if (lists == null || lists.length == 0) {
            return null;
        }

        return devide(lists, 0, lists.length - 1);
    }

    private ListNode devide(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        }

        if (l == r) {
            return lists[l];
        }

        int m = l + (r - l) / 2;
        ListNode first = devide(lists, l, m);
        ListNode second = devide(lists, m + 1, r);
        return merge(first, second);
    }

    private ListNode merge(ListNode f, ListNode s) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (f != null && s != null) {
            if (f.val <= s.val) {
                curr.next = f;
                f = f.next;
            } else {
                curr.next = s;
                s = s.next;
            }
            curr = curr.next;
        }

        if (f != null) {
            curr.next = f;
        } else {
            curr.next = s;
        }

        return dummy.next;
    }
}

/**

*/