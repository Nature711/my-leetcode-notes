class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer, Node> map = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            Node curr;
            if (!map.containsKey(i)) {
                curr = new Node(i);
                map.put(i, curr);
                inDegree.put(i, 0);
            }
            else curr = map.get(i);
            
            if (leftChild[i] != -1) {
                if (!map.containsKey(leftChild[i])) {
                    Node left = new Node(leftChild[i]);
                    map.put(leftChild[i], left);
                }
                curr.left = map.get(leftChild[i]);
                inDegree.put(leftChild[i], inDegree.getOrDefault(leftChild[i], 0) + 1);
                if (inDegree.get(leftChild[i]) > 1) return false;
            }
            
            if (rightChild[i] != -1) {
                if (!map.containsKey(rightChild[i])) {
                    Node right = new Node(rightChild[i]);
                    map.put(rightChild[i], right);
                }
                curr.right = map.get(rightChild[i]);
                inDegree.put(rightChild[i], inDegree.getOrDefault(rightChild[i], 0) + 1);
                if (inDegree.get(rightChild[i]) > 1) return false;
            }
        }
        if (inDegree.size() != n) return false;
        
        int root = -1;
        for (int key: inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                if (root != -1) return false;
                root = key;
            }
        }
        
        if (root == -1) return false;
        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(root);

        while (!q.isEmpty()) {
            //System.out.println(visited);
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int nodeIdx = q.poll();
                Node node = map.get(nodeIdx);
                
                if (node.left != null) {
                    q.add(node.left.val);
                }
                if (node.right != null) {
                    q.add(node.right.val);
                }
                if (!visited.add(node.val)) {
                    return false;
                }
            }
            
        }
        if (visited.size() != n) return false;
        return true;
    }
    
    class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
}