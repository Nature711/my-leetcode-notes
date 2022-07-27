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
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        
        while (head != null && head.next != null) {
            boolean isDuplicate = false;
            if (head.val == head.next.val) {
                isDuplicate = true;
            }
            ListNode nextNode = head.next;
            while (nextNode != null && nextNode.val == head.val) {
                nextNode = nextNode.next;
            }
            if (isDuplicate) {
                prev.next = nextNode;
                head = nextNode;
            } else {
                head.next = nextNode;
                prev = head;
                head = head.next;
            }
        }
        
        return dummy.next;
    }
}
