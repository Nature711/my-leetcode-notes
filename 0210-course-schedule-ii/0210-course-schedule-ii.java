class Solution {
    int[] states;
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    boolean hasCycle = false;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        if (numCourses == 0) return new int[0];
        
        for (int[] prerequisite: prerequisites) {
            if (!map.containsKey(prerequisite[0])) map.put(prerequisite[0], new ArrayList<>());
            map.get(prerequisite[0]).add(prerequisite[1]);
        }
        states = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (states[i] == 0) dfs(i);
            if (hasCycle) return new int[0];
        }
        
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) result[i] = res.get(i);
        return result;
    }
    
    public void dfs(int start) {
        if (hasCycle || states[start] == 2) return; //already taken, don't need to explore
        if (map.containsKey(start)) {
            states[start] = 1; //exploring
            for (int course: map.get(start)) {
                if (states[course] == 1) {
                    hasCycle = true;
                    return;
                }
                dfs(course);
            }
        }
        states[start] = 2; //explored
        res.add(start);
    }
    
}
    
