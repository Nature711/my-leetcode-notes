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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode mid = getMid(head);
        ListNode leftList = sortList(head);
        ListNode rightList = sortList(mid);
        
        return merge(leftList, rightList);
    }
    
    // public ListNode findMiddle(ListNode start) {
    //     if (start == null) return start;
    //     ListNode fast = start.next, slow = start;
    //     while (fast != end && fast.next != end) {
    //         fast = fast.next.next;
    //         slow = slow.next;
    //     }
    //     System.out.println(start.val + " has middle " + slow.val);
    //     return slow;
    // }
    
    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
    
     public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        ListNode dummy = new ListNode();
        System.out.println(list1.val + " merged with " + list2.val);
        
        ListNode prev = dummy, ptr1 = list1, ptr2 = list2;
        
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                prev.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                prev.next = ptr2;
                ptr2 = ptr2.next;
            }
            prev = prev.next;
        }
        
        if (ptr1 != null) prev.next = ptr1;
        if (ptr2 != null) prev.next = ptr2;
        
        return dummy.next;
    }
}