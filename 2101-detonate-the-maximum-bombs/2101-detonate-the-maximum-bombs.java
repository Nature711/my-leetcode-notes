class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        
//         Arrays.sort(bombs, (b1, b2) -> {
//             int deltaX = b1[0] - b2[0];
//             if (deltaX != 0) return deltaX;
//             else return b1[1] - b2[1];
//         });
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                double d = Math.sqrt(Math.pow(bombs[j][1] - bombs[i][1], 2) + 
                    Math.pow(bombs[j][0] - bombs[i][0], 2));
                if (d <= bombs[i][2]) {
                    if (graph.containsKey(i)) graph.get(i).add(j);
                    else {
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        graph.put(i, list);
                    }
                }
                
            }
        }
        int maxDetonation = 1;
        for (int i = 0; i < n; i++) {
            maxDetonation = Math.max(maxDetonation, dfs(i, new HashSet<>()));
        }
        return maxDetonation;
    }
    
    public int dfs(int start, Set<Integer> visited) {
        visited.add(start);
        int total = 1;
        if (graph.containsKey(start)) {
            List<Integer> neighbors = graph.get(start);
            for (int nei: neighbors) {
                if (!visited.contains(nei)) total += dfs(nei, visited);
            }
        }
        return total;
    }
    
    
}