class Solution {
   
    HashSet<Integer> visited = new HashSet<>();
    List<List<Integer>> graph = new ArrayList();
    
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
     
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != j && (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        System.out.println(graph);
        
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                //System.out.println("dfs from " + i + " called from main");
                dfs(i);
                count++;
            }
        }
        
        return n - count;
    }
    
    public void dfs(int start) {
        
        visited.add(start);
        List<Integer> neighbors = graph.get(start);
        
        for (int neighbor: neighbors) {
            if (!visited.contains(neighbor)) {
                //System.out.println("dfs from " + neighbor + " called from recursive");
                dfs(neighbor);
                
            }
        }
    }
}

