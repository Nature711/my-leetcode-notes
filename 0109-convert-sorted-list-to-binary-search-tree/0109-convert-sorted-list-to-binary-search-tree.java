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
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode ptr = head;
        int n = 0;
        while (ptr != null) {
            ptr = ptr.next;
            n++;
        }
        return toBST(head, n);
    }
   
    public TreeNode toBST(ListNode head, int n) {
        
        if (head == null || n == 0) return null;
        
        ListNode mid = head;
        int count = (n - 1) / 2;
        while (count > 0) {
            mid = mid.next;
            count--;
        }
    
        TreeNode root = new TreeNode(mid.val);
  
        root.left = toBST(head, (n - 1) / 2);
        root.right = toBST(mid.next, n / 2);
        return root;
    }
    
}