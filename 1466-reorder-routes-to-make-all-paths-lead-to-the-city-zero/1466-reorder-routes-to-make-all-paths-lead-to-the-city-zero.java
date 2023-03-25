class Solution {
    
    Set<Integer> visited = new HashSet<>();
    int reorderCount = 0;
    HashMap<Integer, List<Integer>> incoming = new HashMap<>();
    HashMap<Integer, List<Integer>> outgoing = new HashMap<>();
    
    public int minReorder(int n, int[][] connections) {
        
        //build graph
        for (int[] connection: connections) {
            if (outgoing.containsKey(connection[0])) {
                outgoing.get(connection[0]).add(connection[1]);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(connection[1]);
                outgoing.put(connection[0], l);
            }
            
            if (incoming.containsKey(connection[1])) {
                incoming.get(connection[1]).add(connection[0]);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(connection[0]);
                incoming.put(connection[1], l);
            }
        }
        
        helper(0);
        
        return reorderCount;
    }
    
    public void helper(int n) {
        visited.add(n);
        
        //incoming edges: add to visited
        if (incoming.containsKey(n)) {
            List<Integer> reachableCities = incoming.get(n);
            for (int reachableCity: reachableCities) {
                if (visited.contains(reachableCity)) continue;
                helper(reachableCity);
            }
        }
        
        //outgoing edges: reorient
        if (outgoing.containsKey(n)) {
            List<Integer> citiesToReorient = outgoing.get(n);
            for (int cityToReorient: citiesToReorient) {
                if (visited.contains(cityToReorient)) continue;
                reorderCount++;
                helper(cityToReorient);
            }
        }
        
    }
}