class Solution {
    int[] states; //0 for unvisited, 1 for visiting, 2 for visited
    int[][] globalGraph;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        states = new int[n];
        globalGraph = graph;
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isSafeNode(i)) safeNodes.add(i);
        }
        return safeNodes;
    }
    
    public boolean isSafeNode(int node) {
        if (states[node] == 2) return true;
        if (states[node] == 1) return false;
        states[node] = 1;
        
        for (int neighbor: globalGraph[node]) {
            if (!isSafeNode(neighbor)) return false;
            //else continue
        }
        
        states[node] = 2;
        return true; 
    }
}