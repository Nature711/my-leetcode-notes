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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode low = dummy, high = dummy, curr = head;
        ListNode highStart = null;
        
        while (curr != null) {
            ListNode tmp = curr.next;
            if (curr.val < x) {
                low.next = curr;
                low = low.next;
            } else {
                if (highStart == null) {
                    highStart = curr;
                    high = curr;
                } else {
                    high.next = curr;
                    high = high.next;
                }
            }
            curr = tmp;
        }
        
        if (highStart != null) {
            high.next = null;
            low.next = highStart;
        }
        
        return dummy.next;
    }
}