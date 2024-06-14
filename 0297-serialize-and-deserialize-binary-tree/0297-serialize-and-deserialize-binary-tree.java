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
    StringBuilder sb;
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        preorder(root);
        return sb.toString();
    }
    
    void preorder(TreeNode root) {
        if (root == null) sb.append("#");
        else {
            sb.append(root.val);
            sb.append(",");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<TreeNode> list = parseTree(data);
        return helper(list);
    }
    
    TreeNode helper(List<TreeNode> list) {
        if (list.isEmpty()) return null;
        
        TreeNode root = list.removeFirst();
        if (root == null) return null;
        
        root.left = helper(list);
        root.right = helper(list);
         
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