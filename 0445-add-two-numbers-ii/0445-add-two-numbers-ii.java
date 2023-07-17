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
        Stack<Integer> num1 = new Stack<>(), num2 = new Stack<>(), res = new Stack<>();
        while (l1 != null) {
            num1.push(l1.val);
            l1 = l1.next;
        };
        while (l2 != null) {
            num2.push(l2.val);
            l2 = l2.next;
        };
        
        int sum = 0, carry = 0;
        while (!num1.isEmpty() && !num2.isEmpty()) {
            int temp = num1.pop() + num2.pop() + carry;
            sum = temp % 10;
            carry = temp / 10;
            res.push(sum);
        }
        while (!num1.isEmpty()) {
            int temp = num1.pop() + carry;
            sum = temp % 10;
            carry = temp / 10;
            res.push(sum);
        }
        while (!num2.isEmpty()) {
            int temp = num2.pop() + carry;
            sum = temp % 10;
            carry = temp / 10;
            res.push(sum);
        }
        if (carry == 1) res.push(1);
        
        ListNode resNode = new ListNode(), curr = resNode;
        while (!res.isEmpty()) {
            ListNode newNode = new ListNode();
            newNode.val = res.pop();
            curr.next = newNode;
            curr = curr.next;
        }
        return resNode.next;
    }
}