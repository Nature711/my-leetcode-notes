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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;
        
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                ListNode newNext = curr.next.next;
                while (newNext != null && newNext.val == val)
                    newNext = newNext.next;
                curr.next = newNext;
            }
            curr = curr.next;
        }
        
        return dummy.next;
    }
}