![image](https://user-images.githubusercontent.com/77217430/195235772-785f378a-fb54-431e-b4e9-c6aaa561d74c.png)

- Initialize ```ptr``` to dummy node
- The outer loop ensures step 4
- The inner loop 1 ensures step 2 -- find the Mth node from the given node
  - during this process, if ```ptr``` becomes null (i.e., reaching end of whole list), then directly return head -- since we're in the "keeping" process
  - after exiting from this loop, ```ptr``` will point to the last node to be kept
  - if ```ptr``` eventually points to null, then we break from the outer loop since there's nothing left to do 
- Keep a reference to the "last node to be kept" 
- The inner loop 2 ensures step 3 -- find the Nth node from the given node
  - during this process, if ```ptr``` becomes null (i.e., reaching end of whole list), then we break from this small loop 
  - after exiting from this loop, ```ptr``` will point to the last node to be removed
  - if ```ptr``` eventually points to null (or if it reaches here due to the break), then this means we don't have enough nodes to remove, so we just remove as many as
    we can -- just set the "last node to be kept"'s next pointer to null (i.e., removing all nodes after it)
  - otherwise we link the "last node to be kept" with the "last node to be removed"'s next node, and set the "last node to be removed"'s next pointer to null

```
public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode ptr = dummy;
        
        while (ptr != null) {  //outer loop
            int keepCount = m;
            int removeCount = n;
            
            while (keepCount > 0) { //inner loop 1
                if (ptr == null) return dummy.next; 
                ptr = ptr.next;
                keepCount--;
            }
            if (ptr == null) break;
            ListNode pre = ptr;
            // System.out.println("last node to keep " + pre.val);
            
            while (removeCount > 0) { //inner loop 2
                if (ptr == null) break;
                ptr = ptr.next;
                removeCount--;
            }
            // System.out.println("last node to remove " + ptr.val);
            if (ptr == null) {
                pre.next = null;
                return dummy.next;
            }
            pre.next = ptr.next;
            // System.out.println("link " + pre.val + " to " + ptr.next.val);
            ptr.next = null;
            ptr = pre;
            // System.out.println("ptr now at " + ptr.val);
        }
        
        return dummy.next;
    }
```
