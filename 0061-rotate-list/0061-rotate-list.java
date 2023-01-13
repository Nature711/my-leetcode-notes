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
    public ListNode rotateRight(ListNode head, int k) {
        int n = countNodes(head);
        if (n == 0) return head;
        k = k % n;
        int c = n - k;
        ListNode link = head, newHead = head;
        while (c-- > 1) newHead = newHead.next;
        ListNode curr = newHead.next;
        // System.out.println(curr.val);
        newHead.next = null;
        newHead = curr;
        if (curr == null) return head;
        while (k-- > 1) curr = curr.next;
        curr.next = head;
        System.out.println(newHead.val);
        return newHead;
    }
    
    public int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}