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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode ptr = dummy;
        
        while (ptr != null) {
            int keepCount = m;
            int removeCount = n;
            
            while (keepCount > 0) {
                if (ptr == null) return dummy.next;
                ptr = ptr.next;
                keepCount--;
            }
            if (ptr == null) break;
            ListNode pre = ptr;
            // System.out.println("last node to keep " + pre.val);
            while (removeCount > 0) {
                if (ptr == null) break;
                ptr = ptr.next;
                removeCount--;
            }
            // System.out.println("last node to remove " + ptr.val);
            if (ptr == null) {
                pre.next = null;
                return dummy.next;
            }
            pre.next = ptr.next;
            // System.out.println("link " + pre.val + " to " + ptr.next.val);
            ptr.next = null;
            ptr = pre;
            // System.out.println("ptr now at " + ptr.val);
        }
        
        return dummy.next;
    }
}