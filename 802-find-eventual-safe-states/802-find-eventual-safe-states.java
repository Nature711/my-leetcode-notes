class Solution {
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
    
}