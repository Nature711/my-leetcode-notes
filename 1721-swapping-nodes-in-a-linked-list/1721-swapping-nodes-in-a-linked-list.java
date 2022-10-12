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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode front = dummy;
        ListNode back = dummy;
        ListNode helper = dummy;
        
        int count = k;
        while (count > 0) {
            helper = helper.next;
            count--;
        }
        
        while (helper != null) {
            back = back.next;
            helper = helper.next;
        }
        
        int backVal = back.val;
        
        while (k > 0) {
            front = front.next;
            k--;
        }
    
        
        back.val = front.val;
        front.val = backVal;
        
        return head;
    }
}