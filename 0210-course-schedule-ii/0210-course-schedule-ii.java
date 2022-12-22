class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int[] status; //0 for not visited, 1 for visting, 2 for visited
    List<Integer> order = new ArrayList<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (!canFinish(numCourses, prerequisites)) return new int[]{};
        int[] res = new int[numCourses];
        for (int i = 0; i < res.length; i++) res[i] = order.get(i);
        return res;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        status = new int[numCourses];
        
        for (int[] pre: prerequisites) { //construct prerequiste map
            if (map.containsKey(pre[0])) map.get(pre[0]).add(pre[1]);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(pre[1]);
                map.put(pre[0], list);
            }
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (status[i] == 0) {
                if (!dfs(i)) return false;
            }
        }
        
        return true;
        
    }
   
    public boolean dfs(int start) {
        if (status[start] == 2) return true;
        if (status[start] == 1) return false;
        
        status[start] = 1;
        
        
        if (map.containsKey(start)) {
            List<Integer> prerequisites = map.get(start);
            for (int pre: prerequisites) {
                if (!dfs(pre)) return false;
            }
        }
        
        status[start] = 2;
        order.add(start);
        return true;
    }
}
    
