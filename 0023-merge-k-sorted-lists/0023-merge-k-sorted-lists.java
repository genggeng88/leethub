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
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        int n = lists.length;

        while (n > 1) {
            for (int i = 0; i <= (n - 1) / 2; i++) {
                if (i * 2 + 1 < n) {
                    lists[i] = merge(lists[i * 2], lists[i * 2 + 1]);
                }
                else {
                    lists[i] = lists[i * 2];
                }
            }
            n = (n + 1) / 2;
        }
        return lists[0];
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        if (a == null) return b;
        if (b == null) return a;
        while (a != null && b != null) {
            if (a.val < b.val) {
                curr.next = a;
                a = a.next;
            }
            else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        if (a != null) curr.next = a;
        if (b != null) curr.next = b;
        return dummy.next;
    }
}