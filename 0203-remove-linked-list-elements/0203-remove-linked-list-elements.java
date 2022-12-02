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
        
        ListNode prev = dummy, curr = head;
         
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                curr.next = null;
            } else prev = curr;
            curr = prev.next;
        }
        
        return dummy.next;
        
    }
}