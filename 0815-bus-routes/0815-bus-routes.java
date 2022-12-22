class Solution {
    
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
    
        //for each stop, record the buses that stop at it
        for (int bus = 0; bus < routes.length; bus++) {
            for (int station: routes[bus]) {
                if (map.containsKey(station)) map.get(station).add(bus);
                else {
                    List<Integer> buses = new ArrayList<>();
                    buses.add(bus);
                    map.put(station, buses);
                }
            }
        }  
        int numBuses = 1;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int station = queue.poll();
                List<Integer> busesAtStation = map.get(station);
                for (int bus: busesAtStation) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int reachableStation: routes[bus]) {
                        if (reachableStation == target) return numBuses;
                        queue.add(reachableStation);
                    }
                }
            }
            numBuses++;
        }
        
        return -1;
        
    }
}