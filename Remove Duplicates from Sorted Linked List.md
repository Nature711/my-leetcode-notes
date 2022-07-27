## Method 1

```
  public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
```

## Method 2
- Make use of dummy node
```
   public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        while (head != null && head.next != null) {
            ListNode next = head.next;
            while (next != null && head.val == next.val) next = next.next;
            head.next = next;
            head = head.next;
        }
        
        return dummy.next;
    }
```

## Method 3
```
 public ListNode deleteDuplicates(ListNode head) {
        ListNode ptr = head;
        while (ptr != null) {
            int curr = ptr.val;
            ListNode nextNode = ptr.next;
            while (nextNode != null && nextNode.val == curr) nextNode = nextNode.next;
            ptr.next = nextNode;
            ptr = ptr.next;
        }
        return head;
    }
 ```
