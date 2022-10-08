class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    List<Integer> times = new ArrayList<>();
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) continue;
            List<Integer> list = map.getOrDefault(manager[i], new ArrayList<>());
            list.add(i);
            map.put(manager[i], list);
        }
        
        int[] currTime = new int[]{informTime[headID]};
        
        backtrack(headID, informTime, currTime);
        
        int res = 0;
        for (int time: times) res = Math.max(res, time);
        return res;
    }
    
    public void backtrack(int root, int[] informTime, int[] currTime) {
        
        if (!map.containsKey(root)) {
            times.add(currTime[0]);
            return;
        }
        
        for (int sub: map.get(root)) {
            int oldTime = currTime[0];
            currTime[0] = oldTime + informTime[sub];
            
            backtrack(sub, informTime, currTime);
            currTime[0] = oldTime;
        }
    }
}