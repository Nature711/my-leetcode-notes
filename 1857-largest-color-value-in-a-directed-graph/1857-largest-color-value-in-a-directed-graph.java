class Solution {
    HashMap<Integer, HashMap<Character, Integer>> map = new HashMap<>();
    
    HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    
    HashSet<Integer> visited = new HashSet<>();
    
    String allColors;
    
    public int largestPathValue(String colors, int[][] edges) {
        allColors = colors;
        HashSet<Integer> rootCandidates = new HashSet<>();
        for (int i = 0; i < colors.length(); i++) {
            rootCandidates.add(i);
        }
        
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == edges[i][1]) return -1;
            rootCandidates.remove(edges[i][1]);
            
            if (graph.containsKey(edges[i][0])) {
                graph.get(edges[i][0]).add(edges[i][1]);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(edges[i][1]);
                graph.put(edges[i][0], set);
            }
            
            if (graph.containsKey(edges[i][1])) {
                if (graph.get(edges[i][1]).contains(edges[i][0])) {
                    return -1;
                }
            }
        }
        
        if (rootCandidates.size() == 0) return -1;
        
        int max = 0;
        
        for (int root: rootCandidates) {
            //System.out.println(root);
            dfs(root);
            HashMap<Character, Integer> myMap = map.get(root);
            //System.out.println(myMap);
            for (char c: myMap.keySet()) max = Math.max(max, myMap.get(c));
        }
        
        return max;
    }
    
    public void dfs(int curr) {
        
        visited.add(curr);
        HashMap<Character, Integer> myData = map.getOrDefault(curr, new HashMap<>());
        
        if (graph.containsKey(curr)) {
            for (int child: graph.get(curr)) {
                if (!visited.contains(child)) dfs(child);
                HashMap<Character, Integer> childData = map.get(child);
                for (char c: childData.keySet()) {
                    if (!myData.containsKey(c) || childData.get(c) > myData.get(c)) {
                        myData.put(c, childData.get(c));
                    }
                }
            }
        }
        char myColor = allColors.charAt(curr);
        myData.put(myColor, myData.getOrDefault(myColor, 0) + 1);
        map.put(curr, myData);
        //System.out.println("curr " + curr + " " + myData);
    }
}