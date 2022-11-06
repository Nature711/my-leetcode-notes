## DFS 
- General strategy: 3-color-marking 

```
    int[] states;
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        states = new int[numCourses]; //0 for not explored, 1 for exploroing, 2 for explored
        
        for (int[] prerequisite: prerequisites) {
            if (!map.containsKey(prerequisite[0])) map.put(prerequisite[0], new ArrayList<>());
            map.get(prerequisite[0]).add(prerequisite[1]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (states[i] == 0) {
                if (!dfs(i)) return false;
            }
        }
        
        return true;
    }
    
    
    public boolean dfs(int start) {
        
        if (states[start] == 2) return true; //already taken, don't need to explore
        
        if (!map.containsKey(start)) return true; //no dependency
        
        states[start] = 1; //exploring
         
        for (int course: map.get(start)) {
            if (states[course] == 1) return false; //find cycle; check before calling dfs to reduce unnecessary calls
            if (!dfs(course)) return false;
        }
        
        states[start] = 2; //explored
        return true;
    }
} 
```
