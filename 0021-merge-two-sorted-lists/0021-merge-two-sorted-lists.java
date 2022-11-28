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
        
        ListNode dummy = new ListNode();
        
        dummy.next = list1.val <= list2.val ? list1 : list2;
        
        ListNode prev = dummy, ptr1 = list1, ptr2 = list2;
        
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                prev.next = ptr1;
                prev = ptr1;
                ptr1 = ptr1.next;
            } else {
                prev.next = ptr2;
                prev = ptr2; 
                ptr2 = ptr2.next;
            }
        }
        
        if (ptr1 != null) prev.next = ptr1;
        if (ptr2 != null) prev.next = ptr2;
        
        return dummy.next;
    }
}