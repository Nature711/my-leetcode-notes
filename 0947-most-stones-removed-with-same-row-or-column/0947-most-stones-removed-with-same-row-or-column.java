class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    
    boolean[] visited;
    public int removeStones(int[][] stones) {
        HashMap<Integer, List<Integer>> rowMap = new HashMap<>();
        HashMap<Integer, List<Integer>> colMap = new HashMap<>();
        
        for (int i = 0; i < stones.length; i++) {
            if (!colMap.containsKey(stones[i][0])) colMap.put(stones[i][0], new ArrayList<>());
            colMap.get(stones[i][0]).add(i);
            if (!rowMap.containsKey(stones[i][1])) rowMap.put(stones[i][1], new ArrayList<>());
            rowMap.get(stones[i][1]).add(i);
        }
        
        
        
        for (int i = 0; i < stones.length; i++) {
            List<Integer> sameRowColStonesIdx = new ArrayList<>();
            if (colMap.containsKey(stones[i][0])) {
                for (int x: colMap.get(stones[i][0])) if (x != i) sameRowColStonesIdx.add(x); 
            }
            if (rowMap.containsKey(stones[i][1])) {
                for (int y: rowMap.get(stones[i][1])) if (y != i) sameRowColStonesIdx.add(y); 
            }
            map.put(i, sameRowColStonesIdx);
        }
       // System.out.println(map);
        
        visited =  new boolean[stones.length];
        int removedCount = 0;
        
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i]) {
                removedCount += dfs(i) - 1;
            }
        }
        return removedCount;
    }
    
    public int dfs(int start) {
        visited[start] = true;
        int counts = 1;
        for (int neighbor: map.get(start)) {
            if (!visited[neighbor]) {
                // System.out.println("from " + start + " visit " + neighbor);
                counts += dfs(neighbor);
            }
        }
        // System.out.println("dfs from " + start + " returns " + counts);
        return counts;
    }
    
    
}