## Dummy node
- Use cases:
  - [Remove Nth node from end of list](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
```
public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode pointer = dummy;
        ListNode helper = dummy;
        
        while (n >= 0) {
            helper = helper.next;
            n--;
        }
        
        while (helper != null) {
            helper = helper.next;
            pointer = pointer.next;
        }
        
        
        ListNode toRemove = pointer.next;
        ListNode tempNext = pointer.next.next;
        pointer.next = tempNext;
        toRemove.next = null;
        
        return dummy.next;
        
    }
```
