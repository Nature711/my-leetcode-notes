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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode newHead = dummy.next.next;
        ListNode temp = newHead.next;
        newHead.next = dummy.next;
        dummy.next.next = swapPairs(temp);
        
        return newHead;
    }
}