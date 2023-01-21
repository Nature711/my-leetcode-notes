class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Pair<Integer, Integer>, Integer> costs = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int[] flight: flights) {
            costs.put(new Pair<>(flight[0], flight[1]), flight[2]);
            if (graph.containsKey(flight[0])) graph.get(flight[0]).add(flight[1]);
            else {
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(flight[1]);
                graph.put(flight[0], neighbors);
            }
        }
        
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new Pair<>(src, 0));
        int stops = 0;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
    
        while (!queue.isEmpty() && stops <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> stop = queue.poll();
                int stopId = stop.getKey(), accCost = stop.getValue();
                List<Integer> neighbors = graph.get(stopId);
                
                if (neighbors != null) {
                    for (int neighbor: neighbors) {
                        
                            int updatedCost = accCost + costs.get(new Pair<>(stopId, neighbor));
                            if (updatedCost > dist[neighbor]) continue;
                            dist[neighbor] = updatedCost;
                            queue.add(new Pair<>(neighbor, updatedCost));
                           
                        }
                    }
                }
             stops++;
          }
            
        
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
        
    }
}