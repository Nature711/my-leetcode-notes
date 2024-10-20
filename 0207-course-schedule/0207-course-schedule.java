class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    HashMap<Integer, Integer> status = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] pre: prerequisites) {
            List<Integer> list = graph.getOrDefault(pre[0], new ArrayList<>());
            list.add(pre[1]);
            graph.put(pre[0], list);
        }
        
        for (int i = 0; i < numCourses; i++) status.put(i, 0);
        
        for (int i = 0; i < numCourses; i++) {
            if (status.get(i) == 0) {
                boolean res = dfs(i);
                if (!res) return false;
            }
        }
        
        return true;
    }
    
    
    boolean dfs(int src) {
        if (status.get(src) == 2) return true;
        if (status.get(src) == 1) return false;
        status.put(src, 1);
        
        if (graph.containsKey(src)) {
            List<Integer> neighbors = graph.get(src);
            for (int neighbor: neighbors) {
                boolean res = dfs(neighbor);
                if (!res) return false;
            }
        }
        
        status.put(src, 2);
                 
        return true;
    }
}