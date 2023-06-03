class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int maxTime = 0;
    int[] times;
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        times = informTime;
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) continue;
            if (map.containsKey(manager[i])) map.get(manager[i]).add(i);
            else {
                List<Integer> workers = new ArrayList<>();
                workers.add(i);
                map.put(manager[i], workers);
            }
        }
        
        backtrack(headID, 0);
        return maxTime;
    }
    
    
    public void backtrack(int start, int cumuTime) {
        if (!map.containsKey(start)) {
            maxTime = Math.max(cumuTime, maxTime);
            return;
        } 
        
        List<Integer> workers = map.get(start);
        for (int worker: workers) {
            backtrack(worker, cumuTime + times[start]);
        }
        
    }
}