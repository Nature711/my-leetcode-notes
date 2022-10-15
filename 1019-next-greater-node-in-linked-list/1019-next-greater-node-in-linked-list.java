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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> resList = new ArrayList<>();
        ListNode ptr = head;
        while (ptr != null) {
            ListNode finder = ptr.next;
            boolean found = false;
            while (finder != null) {
                if (finder.val > ptr.val) {
                    resList.add(finder.val);
                    found = true;
                    break;
                }
                finder = finder.next;
            }
            if (!found) resList.add(0);
            ptr = ptr.next;
        }
        
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) res[i] = resList.get(i);
        
        return res;
    }
}