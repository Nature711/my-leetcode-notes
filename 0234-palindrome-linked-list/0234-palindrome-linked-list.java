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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int half = stack.size() / 2;
        Stack<Integer> temp = new Stack<>();
        while (half-- > 0) temp.push(stack.pop());
        if (stack.size() > temp.size()) stack.pop();

        while (stack.size() > 0) if (stack.pop() != temp.pop()) return false;
        return true;
    }
}