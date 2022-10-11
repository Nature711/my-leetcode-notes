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
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode pointer = dummy;
        ListNode helper = dummy;
        
        while (n >= 0) {
            helper = helper.next;
            n--;
        }
        
        
        while (helper != null) {
            helper = helper.next;
            pointer = pointer.next;
        }
        
        
        ListNode toRemove = pointer.next;
        ListNode tempNext = pointer.next.next;
        pointer.next = tempNext;
        toRemove.next = null;
        
        return dummy.next;
        
    }
}