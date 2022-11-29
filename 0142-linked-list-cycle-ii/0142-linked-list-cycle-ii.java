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
        
        ListNode fast = head.next, slow = head;
        
        while (fast != slow) {
            if (fast == null || fast.next == null) return null; //no cycle
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode ptr1 = head, ptr2 = fast.next;
        
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
}