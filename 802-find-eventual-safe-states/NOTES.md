## DFS with visited
- need to have a set "visited" to keep track of if a node is visited; otherwise will be stuck in an infinite loop if there's a cycle
- if a node is visited and we encounter it again during our DFS, we can directly return whether it's being marked as a safe node or not
```
 Set<Integer> safeNodes = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        for (int i = graph.length - 1; i >= 0; i--) {
            if (graph[i].length == 0) {
                safeNodes.add(i);
                visited.add(i);
            } else isSafeNode(i, graph);
        }
        List<Integer> res = new ArrayList<>();
        for (int node: safeNodes) res.add(node);
        Collections.sort(res);
        return res;
    }
    
    public boolean isSafeNode(int node, int[][] graph) {
     
        if (visited.contains(node)) return safeNodes.contains(node);
        
        visited.add(node);
  
        for (int out: graph[node]) {
            if (!isSafeNode(out, graph)) return false;
        }
        
        safeNodes.add(node);
        
        return true;
    }
 ```
 
 ## DFS with marking
 - better time complexity
 ```
   public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] color = new int[N];
        List<Integer> ans = new ArrayList();

        for (int i = 0; i < N; ++i)
            if (dfs(i, color, graph))
                ans.add(i);
        return ans;
    }

    // colors: WHITE 0, GRAY 1, BLACK 2;
    public boolean dfs(int node, int[] color, int[][] graph) {
        if (color[node] > 0) //visited
            return color[node] == 2;

        color[node] = 1; //assume it's not a safe node
        for (int nei: graph[node]) {
            if (!dfs(nei, color, graph)) return false;
        }

        color[node] = 2; //if nothing goes wrong (i.e., each of its outgoing edge leads to safe node, then we change our assumption to say it's indeed a safe node
        return true;
    }
  ```
 
