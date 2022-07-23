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
        ListNode sStart = new ListNode();
        ListNode lStart = new ListNode();
        ListNode sCurr = sStart;
        ListNode lCurr = lStart;
        
        while (head != null) {
            if (head.val < x) {
                sCurr.next = head;
                sCurr = sCurr.next;
            } else {
                lCurr.next = head;
                lCurr = lCurr.next;
            }
            head = head.next;
        }
        
        
        sCurr.next = lStart.next;
        lCurr.next = null;
        
        return sStart.next;
        
    }
}