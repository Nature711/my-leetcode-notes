## Recursion 1
- reference to head of list
- reverse sublist starting from head.next; reference to the head of reversed sublist
- traverse to the end of the sublist
- append head of old list to the end of the reversed sublist
- return head of the reversed sublist
```
   public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode revHead = reverseList(head.next);
        
        ListNode temp = revHead;
        while (temp.next != null) temp = temp.next;
        
        head.next = null;
        temp.next = head;
            
        return revHead;
    }
```

## Recursion 2

illustration
```
p = reverseList(head.next)                   
1 -> (2 <- 3 <- 4 <- 5)
^                    ^
head                 p

head.next.next = head;
1 <-> (2 <- 3 <- 4 <- 5)
^                     ^
head                  p

head.next = null;
1 <- (2 <- 3 <- 4 <- 5)
^                    ^
head                 p
```

code
```
   public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
```

## Recursion (not in space)
```
 public static ListNode reverseList(ListNode head) {
            if (head == null) return null;
            return append(reverseList(head.next), new ListNode(head.val));
        }

        public static ListNode append(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            return new ListNode(l1.val, append(l1.next , l2));
        }
 
```



## Iterative
```
public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next;
        
        while (curr != null) {
            next = curr.next;
            
            curr.next = prev;
            
            if (prev == dummy) curr.next = null;
            
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
```
