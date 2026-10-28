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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1)) return null;
        ListNode first = head;
        int k = n;
        while (k > 0) {
            first = first.next;
            k--;
        }
        
        if (first == null) return head.next;

        ListNode second = head, prev = null;
        while (first != null) {
            first = first.next;
            prev = second;
            second = second.next;
        }
        prev.next = second.next;
        return head;
    }
}