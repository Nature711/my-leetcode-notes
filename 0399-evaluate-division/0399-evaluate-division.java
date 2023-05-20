class Solution {
    Map<Pair<String, String>, Double> edges = new HashMap<>(); 
    Map<String, List<String>> neighbors = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String eq1 = equations.get(i).get(0), eq2 = equations.get(i).get(1);
            Pair<String, String> key1 = new Pair<>(eq1, eq2);
            edges.put(key1, values[i]);
            Pair<String, String> key2 = new Pair<>(eq2, eq1);
            edges.put(key2, 1.0 / values[i]);
            
            if (!neighbors.containsKey(eq1)) {
                List<String> nei = new ArrayList<>();
                nei.add(eq2);
                neighbors.put(eq1, nei);
            } else neighbors.get(eq1).add(eq2);
            if (!neighbors.containsKey(eq2)) {
                List<String> nei = new ArrayList<>();
                nei.add(eq1);
                neighbors.put(eq2, nei);
            } else neighbors.get(eq2).add(eq1);
            
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            String eq1 = queries.get(i).get(0), eq2 = queries.get(i).get(1);
            if(!neighbors.containsKey(eq1) || !neighbors.containsKey(eq2)) 
                res[i] = -1.0;  // If any variable in the query doesn't exist in the graph, it cannot be solved
            else 
                res[i] = dfs(eq1, eq2, 1.0, new HashSet<>());
        
        }
        return res;
    }
    
    public double dfs(String start, String target, double multiplier, Set<String> visited) {
        visited.add(start);
        if (start.equals(target)) return multiplier;
        
        if (neighbors.containsKey(start)) {
            for (String eq: neighbors.get(start)) {
                if (visited.contains(eq)) continue;
                
                Pair<String, String> k = new Pair<>(start, eq);
                if (edges.containsKey(k)) {
                    double newMultiplier = multiplier * edges.get(k);
                    double rem = dfs(eq, target, newMultiplier, visited);
                    if (rem != -1.0) return rem;
                }
                
            }
        }
        visited.remove(start);
        return -1.0;
        
    }
}