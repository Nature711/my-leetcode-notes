- Note1: to remove the Nth node from the end of list, we do so by setting "the N+1th node from end of list"'s next to the "N-1the node from end of list"
- To do so, we actually need to keep reference to the N+1th node from end of list (rather than the Nth)
- Therefore we maintain the distance between 2 pointers to be N + 1 -- this is effectively done by setting while loop condition to ```n >= 0``` instead of just ```n > 0```. This way we run the loop one more time
- After the second while loop, the fast pointer (i.e., helper) reaches the end, the slow pointer (i.e., ptr) points to the N+1th node from end of list
- The node to be removed (i.e., Nth node from end of list) is ```ptr.next```
- The node to which the "N+1th node from end of list" will link (i.e., the "N-1th node from end of list) is ```ptr.next.next```
```
   public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode pointer = dummy;
        ListNode helper = dummy;
        
        while (n >= 0) { //note1
            helper = helper.next;
            n--;
        }
        
        while (helper != null) {
            helper = helper.next;
            pointer = pointer.next;
        }
        
        
        ListNode toRemove = pointer.next; //step A
        ListNode tempNext = toRemove.next; //step B 
        pointer.next = tempNext;
        toRemove.next = null;
        
        return dummy.next;
        
    }
  ```
  
  ![image](https://user-images.githubusercontent.com/77217430/195243427-5aa86db6-00a2-49bd-98c2-27656a4edac2.png)
  
Why we're sure that step A & B are safe?
  - i.e., after exiting from the second while loop, pointer is at least 2 nodes away from end of list

- by problem constraint: 1 <= n <= no_of_nodes_in_graph

- edge case 1: n == 1
  - want to remove the 1st node from end of list (i.e., the last node of list)
  - ptr will stop at the 2nd node from end of list (i.e., the second last node of list)
  - toRemove = ptr.next --> is the last node
  - tempNext = ptr.next.next --> is null
 
 - edge case 2: n == no_of_nodes_in_graph
  - want to remove the first node of list
  - ptr will stop at the dummy node (not moving at all)
  - toRemove = ptr.next --> is the actual head (first node of list)
  - tempNext = ptr.next.next --> is the second node of list
  
 Both edge cases are safely covered :D

  
