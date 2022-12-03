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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head, next = head;
        while (curr != null) {
            next = curr.next;
            while (next != null && next.val == curr.val) next = next.next;
            curr.next = next;
            curr = curr.next;
        }
        return dummy.next;
    }
}