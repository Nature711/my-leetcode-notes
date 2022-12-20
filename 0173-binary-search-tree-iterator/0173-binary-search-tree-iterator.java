/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode root;

    public BSTIterator(TreeNode root) {
        this.root = root;
    }
    
    public int next() {
        TreeNode leaf = leftmost();
        this.root = leaf.right;
        return leaf.val;
    }
    
    public boolean hasNext() {
        return !this.stack.isEmpty() || this.root != null;
    }

    public TreeNode leftmost() {
        while (this.root != null) {
            this.stack.push(this.root);
            this.root = this.root.left;
        }
        return stack.pop();
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */