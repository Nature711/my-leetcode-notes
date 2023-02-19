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
import java.math.BigInteger;
class Solution {
    public ListNode plusOne(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(Integer.toString(head.val));
            head = head.next;
        }
        BigInteger num = new BigInteger(sb.toString());
        num = num.add(new BigInteger("1"));
        
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        for (char c: num.toString().toCharArray()) {
            curr.next = new ListNode(Character.getNumericValue(c));
            curr = curr.next;
        }
        
        return dummy.next;
    }
}