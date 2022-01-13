### Related Problems
- Longest Consecutive Sequence(https://leetcode.com/problems/longest-consecutive-sequence/)
- Number of Provinces(https://leetcode.com/problems/number-of-provinces/)

### Sample Code

## Version 1: Value of each node doesn't matter
```
public class UnionFind {
    private int[] parents;
    private int[] size;
    int numOfComponets = 0;

    public UnionFind(int n) {
        parents = new int[n];
        size = new int[n];
        numOfComponets = n;
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public int find(int cur) {
        int root = cur;
        while (root != parents[root]) {
            root = parents[root];
        }
        // Path Compression
        while (cur != root) {
            int preParent = parents[cur];
            parents[cur] = root;
            cur = preParent;
        }
        return root;
    }

    public int findComponentSize(int cur) {
        int parent = find(cur);
        return size[parent];
    }

    public void union(int node1, int node2) {
        int node1Parent = find(node1);
        int node2Parent = find(node2);

        if (node1Parent == node2Parent)
            return;

        if (size[node1Parent] > size[node2Parent]) {
            parents[node2Parent] = node1Parent;
            size[node1Parent] += size[node2Parent];
        } else {
            parents[node1Parent] = node2Parent;
            size[node2Parent] += size[node1Parent];
        }
        numOfComponets--;
    }
}
```

## Version 2: Value of each node matters
```
class Solution {
    Map<Integer, Integer> ids = new HashMap<>();
    Map<Integer, Integer> size = new HashMap<>();
    
    public int longestConsecutive(int[] nums) {
        
        for(int num: nums){
            ids.put(num, num);
            size.put(num, 1);
        }
        
        for(int num: nums){
            if(ids.containsKey(num+1)){
                union(num, num+1);
            }
        }
        
        int maxSize = 0;
        for(int curr: size.values()){
            maxSize = Math.max(maxSize, curr);
        }
        
        return maxSize;
    }
    
    public void union(int p1, int p2){
        int p1id = find(p1);
        int p2id = find(p2);
        
        if(p1id==p2id) return;
        
        if(p1id>p2id){
            ids.put(p2id, p1id);
            size.put(p1id, size.get(p2id) + size.get(p1id));
        } else{
            ids.put(p1id, p2id);
            size.put(p2id, size.get(p1id) + size.get(p2id));
        }
    }
    
    public int find(int p){
        int root = p;
        while(root!=ids.get(root)){
            root=ids.get(root);
        }
        
        while(p!=root){
            int next = ids.get(p);
            ids.put(p, root);
            p = next;
        }
        
        return root;
    }
}
```
