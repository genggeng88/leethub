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
        int n = lists.length;
        return helper(0, n - 1, lists);
    }

    private ListNode helper(int l, int r, ListNode[] lists) {
        if (l == r) return lists[l];
        if (l > r) return null;

        int m = l + (r - l)/2;
        
        ListNode left = helper(l, m, lists);
        ListNode right = helper(m+1, r, lists);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy, l = left, r = right;
        while (l != null && r != null) {
            if (l.val < r.val) {
                curr.next = l;
                l = l.next;
            }
            else {
                curr.next = r;
                r = r.next;
            }
            curr = curr.next;
        }
        if (l != null) curr.next = l;
        if (r != null) curr.next = r;
        
        return dummy.next;
    }
}