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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = head.next;
        
        while (next != null) {
            
            curr.next = prev;
            
            if (prev == dummy) curr.next = null;
            
            prev = curr;
            curr = next;
            next = next.next;
        }
        
        curr.next = prev;
        return curr;
    }
    
}