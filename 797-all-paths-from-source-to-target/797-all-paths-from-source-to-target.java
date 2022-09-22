class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<Integer> currPath = new ArrayList<>();
        currPath.add(0);

        dfs(graph, currPath, 0, graph.length - 1);
        
        return res;
    }
    
    public void dfs(int[][] graph, List<Integer> currPath, int curr, int target) {
        
        if (curr == graph.length) return;
        
        if (currPath.get(currPath.size() - 1) == target) {
            List<Integer> validPath = new ArrayList<>(currPath);
            res.add(validPath);
            return;
        }
        
        for (int i: graph[curr]) {
            currPath.add(i);
            dfs(graph, currPath, i, target);
            currPath.remove(currPath.size() - 1);
        }
    }
}