/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if (head == null) return null;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        while (true) {
            if (fast == null || fast.next == null) return null;
            if (slow != dummy && fast == slow) break;
            slow = slow.next; 
            fast = fast.next.next;
        }
        
        ListNode ptr = dummy;
        
        while (ptr != slow) {
            ptr = ptr.next;
            slow = slow.next;
        }
        
        return ptr;
        
    }
}