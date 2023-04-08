/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    HashMap<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        clone(node);
        return map.get(node.val);
    }
    
    public void clone(Node node) {
        if (!map.containsKey(node.val)) {
            Node n = new Node(node.val);
            map.put(node.val, n);
        }
        
        Node newNode = map.get(node.val);
        
        for (Node nbr: node.neighbors) {
            if (!map.containsKey(nbr.val)) {
                Node n = new Node(nbr.val);
                map.put(nbr.val, n);
                clone(nbr);
            }
            newNode.neighbors.add(map.get(nbr.val));
        }
    }
}