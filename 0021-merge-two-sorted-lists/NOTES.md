## Recursion

```
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }
```

## O(n) space

```
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
```

## In-place 

- maintain a prev pointer, which points to the current node for which we are considering adjusting its next pointer.
- if the value at l1 is less than or equal to the value at l2, then we connect l1 to the previous node and increment l1. 
- Otherwise, we do the same, but for l2. 
- Then, regardless of which list we connected, we increment prev to keep it one step behind one of our list heads.

![image](https://user-images.githubusercontent.com/77217430/204180250-b49b60d2-155f-4e74-b4d2-d2f07062c66d.png)
![image](https://user-images.githubusercontent.com/77217430/204180263-3ad01f8b-3fd6-4243-b31f-1080ac6b1a6f.png)
![image](https://user-images.githubusercontent.com/77217430/204180301-cc9a7df8-fa43-40ce-a99d-e258ef042d3e.png)
![image](https://user-images.githubusercontent.com/77217430/204180312-450b85d7-d7cc-40e9-a237-e0d39e4123e2.png)
![image](https://user-images.githubusercontent.com/77217430/204180330-f5ccdc1f-217f-4932-a144-b5bcea4d33cf.png)
![image](https://user-images.githubusercontent.com/77217430/204180346-90b2111e-62a2-4bab-90b8-ac8afa84d913.png)
![image](https://user-images.githubusercontent.com/77217430/204180361-42070396-58b3-4325-94df-e31d2d874eb8.png)
![image](https://user-images.githubusercontent.com/77217430/204180380-52072f1e-88b1-4b4b-a9cb-4ec5cc3c7db3.png)

```
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        ListNode dummy = new ListNode();
        
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
```
