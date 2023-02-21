/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        Node dummy = new Node();
        Node curr = dummy, tmp;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            if (tmp.next != null) stack.push(tmp.next);
            if (tmp.child != null) stack.push(tmp.child);
            curr.next = tmp;
            tmp.prev = curr;
            tmp.child = null;
            curr = tmp;
        }
        dummy.next.prev = null;
        return dummy.next;
    }
}