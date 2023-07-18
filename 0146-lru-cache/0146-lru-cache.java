class LRUCache {
    HashMap<Integer, ListNode> map;
    ListNode head, tail;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.cap = capacity;
    }
    
    public int get(int key) {
 
        
        if (!map.containsKey(key)) {
          
            return -1;
        }
            
        ListNode node = map.get(key);
        
        if (node == head) {
  
            return head.val;
        }

        ListNode nNext = node.next, nPrev = node.prev;
        node.next = head;
        node.prev = null;
        head.prev = node;
        nPrev.next = nNext;
        if (nNext != null) nNext.prev = nPrev;
        head = node;
        
        if (node == tail) tail = nPrev;
     
        return node.val;
    }
    
    public void put(int key, int value) {
       
        
        int res = this.get(key);
        if (res == -1) { //add new kv pair
            if (map.size() == cap) { //exceeds capacity, evict LRU
                map.remove(tail.key);
                ListNode tmp = tail.prev;
                if (tmp != null) {
                    tmp.next = null;
                    tail = tmp;
                } else {
                    head = null;
                    tail = null;
                }
            }
            ListNode newNode = new ListNode(key, value);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            map.put(key, newNode);
        } else { //the exisiting kv pair node is already moved to front (head)
            head.val = value; //update value of existing kv pair
        }
  
    }
    
    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    public void printList() {
        ListNode ptr = head;
        System.out.print("list ");
        while (ptr != null) {
            System.out.print(ptr.key + " ");
            ptr = ptr.next;
        }
        System.out.println("end ");
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */