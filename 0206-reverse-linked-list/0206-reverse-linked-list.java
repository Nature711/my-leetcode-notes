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
        if (head == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode prev = dummy, curr = head, next;
        ListNode h = head;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            if (curr == h) curr.next = null;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
}