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
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKHelper(lists, 0, lists.length - 1);
    }
    
    public ListNode mergeKHelper(ListNode[] lists, int low, int high) {
        
        if (low > high) return null;
        if (low == high) return lists[low];
        if (low == high - 1) return mergeTwoLists(lists[low], lists[high]);
        int mid = low + (high - low) / 2;
        
        ListNode firstHalf = mergeKHelper(lists, low, mid);
        ListNode secondHalf = mergeKHelper(lists, mid + 1, high);
        
        return mergeTwoLists(firstHalf, secondHalf);
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null) curr.next = list1;
        if (list2 != null) curr.next = list2;

        return dummy.next;

    }
}



