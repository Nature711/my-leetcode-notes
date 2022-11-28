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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        ListNode res = new ListNode();
        ListNode headRef = res;
        
        ListNode ptr1 = list1, ptr2 = list2;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                res.next = new ListNode(ptr1.val);
                ptr1 = ptr1.next;
            } else {
                res.next = new ListNode(ptr2.val);
                ptr2 = ptr2.next;
            }
            res = res.next;
        }
        
        while (ptr1 != null) {
            res.next = new ListNode(ptr1.val);
            ptr1 = ptr1.next;
            res = res.next;
        }
        
        
        while (ptr2 != null) {
            res.next = new ListNode(ptr2.val);
            ptr2 = ptr2.next;
            res = res.next;
        }
        
        return headRef.next;
    }
}