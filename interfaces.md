## Queue (FIFO)

- Initialization: 
  - normal queue: ```Queue<T> queue = new LinkedList<>();```
  - priority queue: 
      - default: ```PriorityQueue<T> pq = new PriorityQueue<>();```
        - 💡 the default pq for int arranges the elements in ascending order (i.e., min element has highest priority)
      - with customized comparator: ```PriorityQueue<T> pq = new PriorityQueue<>(comparator);```
        - min element has higher priority (default): ```(a, b) -> a - b```
        - max element has higher priority: ```(a, b) -> b - a```
        - smaller first element in pair has higher priority: ```(p1, p2) -> p1.getKey() - p2.getKey()```
        - smaller second element in pair has higher priority: ```(p1, p2) -> p1.getValue() - p2.getValue()```
  
- Operations
  - add an element: ```queue.add(ele)```
  - remove an element (from front): ```queue.remove()```
  - peek the frontmost element: ```queue.peek()```
  

## Stack (LIFO)

- Initialization: ```Stack<T> stack = new Stack<>();```
  
- Operations
  - add an element: ```stack.push(ele)```
  - remove an element (from top): ```stack.pop()```
  - peek the uppermost element: ```stack.peek()```
  
  
## HashMap 

- Initialization: ```HashMap<T, Q> map = new HashMap<>()```
  
- Operations
  - add a key-value pair: ```map.put(key, value)```
    - 💡 if there is already a pair with the same key, this new pair will override the previous
  - check if an element exists (by key): ```map.containsKey(key)```
  - get an element by key (returns the value of that pair): ```map.get(key)```
    - 💡 if we want to return some default value when the element DNE, use ```map.getOrDefault(key, defaultValue)```
