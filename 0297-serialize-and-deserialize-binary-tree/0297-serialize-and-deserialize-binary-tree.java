/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                if (curr != null) {
                    sb.append(curr.val);
                    sb.append(",");
                    q.add(curr.left);
                    q.add(curr.right);
                } else {
                    sb.append("#");
                }
            }
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<TreeNode> list = parseTree(data);
      
        TreeNode root = list.get(0);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr != null) {
                curr.left = list.get(i++);
                curr.right = list.get(i++);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        
        return root;
    }
    
    List<TreeNode> parseTree(String data) {
        List<TreeNode> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            if (Character.isDigit(data.charAt(i)) || data.charAt(i) == '-') {
                sb.append(data.charAt(i));
            } else if (data.charAt(i) == ',') {
                TreeNode currNode = new TreeNode(Integer.valueOf(sb.toString()));
                res.add(currNode);
                sb = new StringBuilder();
            } else { // "#"
                res.add(null);
            }
        }
        return res;
    }
   
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));