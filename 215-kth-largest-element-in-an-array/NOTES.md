## Heap
- implementation: priority queue
```
PriorityQueue pq = new PriorityQueue(); //default: min heap
PriorityQueue pq = new PriorityQueue((x, y) -> y - x); //max heap
```

## Min heap
- iterate over size n array
- maintain min heap of size k
- need to poll out (n - k) elements in total
- those are the smaller (n - k) elements
- the remaining k elements are on the larger side
- fianlly the root is the kth largest element of whole array

## Max heap
- iterate over size n array
- maintain max heap of size (n - k)
- need to poll out k elements in total
- those are the larger k elements
- the remaining (n - k) elements are on the smaller side
- fianlly the root is the (n - k)th smallest, i.e., kth largest, element of whole array
