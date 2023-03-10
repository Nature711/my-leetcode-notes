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
    List<Integer> list = new ArrayList<>();
    int n = 0;
    Random rand = new Random();

    public Solution(ListNode head) {
        
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        n = list.size();
    }
    
    public int getRandom() {
        int id = rand.nextInt(n);
        return list.get(id);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */