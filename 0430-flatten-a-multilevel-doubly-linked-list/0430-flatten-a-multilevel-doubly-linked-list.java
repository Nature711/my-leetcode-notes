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
        //invariant: all the nodes up to and including curr have their child been flatten (i.e., at a single level)
        Stack<Node> stack = new Stack<>();
        //stack to store the nodes to be processed -- LIFO
        stack.push(head);
        while (!stack.isEmpty()) {
            tmp = stack.pop(); 
            if (tmp.next != null) stack.push(tmp.next); //add node's next first to delay its evaluation -- only after the tmp node's children have been processed
            if (tmp.child != null) stack.push(tmp.child); //add node's child later which will be processed immediately in the next iteration
            curr.next = tmp;
            tmp.prev = curr;
            tmp.child = null;
            curr = tmp;
        }
        dummy.next.prev = null;
        return dummy.next;
    }
}