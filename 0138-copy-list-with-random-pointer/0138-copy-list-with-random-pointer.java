/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // public Node copyRandomList(Node head) {
    //     HashMap<Node, Node> map = new HashMap<>();
    //     Node ptr = head;
    //     Node dummy = new Node(0);
    //     Node curr = dummy;
    //     while (ptr != null) {
    //         Node newNode = new Node(ptr.val);
    //         map.put(ptr, newNode);
    //         curr.next = newNode;
    //         ptr = ptr.next;
    //         curr = curr.next;
    //     }
    //     ptr = head;
    //     curr = dummy.next;
    //     while (ptr != null) {
    //         if (ptr.random != null) {
    //             curr.random = map.get(ptr.random);
    //         }
    //         curr = curr.next;
    //         ptr = ptr.next;
    //     }
    //     return dummy.next;
    // }
    HashMap<Node, Node> map = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        
        if (head == null) return null;
        if (map.containsKey(head)) return map.get(head);
        
        Node headCopy = new Node(head.val);

        map.put(head, headCopy);
        
        Node subproblem = copyRandomList(head.next);
        headCopy.next = copyRandomList(head.next);
        headCopy.random = copyRandomList(head.random);
        
        return headCopy;
    }
}