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
        
        ListNode revHead = reverseList(head.next);
        
        ListNode temp = revHead;
        while (temp.next != null) temp = temp.next;
        
        head.next = null;
        temp.next = head;
            
        return revHead;
    }
    
    
}