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
        ListNode ptr = head;
        while (ptr != null) {
            int curr = ptr.val;
            ListNode nextNode = ptr;
            while (nextNode != null && nextNode.val == curr) nextNode = nextNode.next;
            ptr.next = nextNode;
            ptr = ptr.next;
        }
        return head;
    }
}