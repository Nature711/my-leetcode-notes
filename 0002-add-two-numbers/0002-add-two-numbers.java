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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0, carry = 0;
        ListNode res = new ListNode();
        ListNode curr = res;
        
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum < 10 ? 0 : 1;
            curr.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }
        
        while (l1 != null) {
            sum = l1.val + carry;
            carry = sum < 10 ? 0 : 1;
            curr.next = new ListNode(sum % 10);
            l1 = l1.next;
            curr = curr.next;
        }
        
        while (l2 != null) {
            sum = l2.val + carry;
            carry = sum < 10 ? 0 : 1;
            curr.next = new ListNode(sum % 10);
            l2 = l2.next;
            curr = curr.next;
        }
        
        if (carry != 0) curr.next = new ListNode(1);
        
        return res.next;
    }
}