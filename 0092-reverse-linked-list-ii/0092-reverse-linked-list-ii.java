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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if (head == null || head.next == null) return head;
        
        if (left == right) return head;
        
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode prev = dummy;
        int count = left;
        while (count-- > 1) prev = prev.next;
        
        ListNode temp1 = prev;
        
        prev = prev.next;
        
        ListNode temp2 = prev;
        
        ListNode curr = prev.next;
        ListNode next = curr.next;

        int steps = right - left;
        
        while (steps-- > 0) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) next = next.next;
        }
        
        temp2.next = curr;
        temp1.next = prev;
        
        return dummy.next;
    }
}