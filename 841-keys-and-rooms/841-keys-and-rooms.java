class Solution {
    
    boolean canVisit = false;
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> keys = new HashSet<>();
        keys.add(0);
        
        dfs(keys, rooms, 0);
        
        return canVisit;
    }
    
    
    public void dfs(HashSet<Integer> currKeys, List<List<Integer>> rooms, int curr) {
        if (currKeys.size() == rooms.size()) {
            canVisit = true;
            return;
        }
    
        for (int key: rooms.get(curr)) {
            boolean canAdd = currKeys.add(key);
            if (!canAdd) continue;
            dfs(currKeys, rooms, key);
        }
        
    }
}