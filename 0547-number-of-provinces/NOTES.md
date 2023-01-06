## Union Find
```
    public int findCircleNum(int[][] isConnected) {
        
        
        int n = isConnected.length;

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) uf.union(i, j);
            }
        }
        
        return uf.numOfComponets;
        
    }
```

## DFS

```
    HashSet<Integer> visited = new HashSet<>();
    List<HashSet<Integer>> graph = new ArrayList<>();
    
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        int count = 0;
        
        //construct graph
        for (int i = 0; i < n; i++) graph.add(new HashSet<>());
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        //dfs from each city
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i);
                count++;
            }
        }
        
        //return result
        return count;
    }
    
    public void dfs(int start) {
        visited.add(start);
        HashSet<Integer> neighbors = graph.get(start);
        for (int n: neighbors) if (!visited.contains(n)) dfs(n);
    }
 ```
