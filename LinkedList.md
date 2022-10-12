## Pointer movement

Goal: to find the Nth node from the start of the list
- Attempt 1: 
  - This didn't work -- the loop body will run exactly n times, each time moving ```ptr``` a node forward; after exiting from the loop, ```ptr``` will point to the
    (N + 1)th node from the start
```
ListNode ptr = head;
while (n > 0) {
     ptr = ptr.next;
     n--;
}
```
- A dummy node solves the problem!
```
ListNode dummy = new ListNode();
dummy.next = head;
ListNode ptr = dummy;
while (steps > 0) {
     ptr = ptr.next;
     n--;
}
```

## Related problems
- [Delete N nodes after M nodes](https://github.com/Nature711/my-leetcode-notes/blob/master/1474-delete-n-nodes-after-m-nodes-of-a-linked-list/1474-delete-n-nodes-after-m-nodes-of-a-linked-list.java)
- [Removing Nth node from end of list]()
- [Swapping nodes in linked list](https://leetcode.com/problems/swapping-nodes-in-a-linked-list/)

