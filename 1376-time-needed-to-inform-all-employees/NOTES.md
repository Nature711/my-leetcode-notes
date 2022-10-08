## Failed attempt, BFS
- this takes the max time at each level and goes down the deepest level, but the path that takes longest time is not necessarily the one that has the max value at each level of going down
```
  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int totalTime = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(headID);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) continue;
            List<Integer> list = map.getOrDefault(manager[i], new ArrayList<>());
            list.add(i);
            map.put(manager[i], list);
        }
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            int currMaxTime = 0;
            
            for (int i = 0; i < size; i++) {
                int currE = queue.poll();
                
                currMaxTime = Math.max(currMaxTime, informTime[currE]);
                
                if (map.containsKey(currE)) {
                    List<Integer> subList = map.get(currE);
                    for (int sub: subList) queue.add(sub);
                }
            }
            totalTime += currMaxTime;
        }
        
        return totalTime;
        
    }
```


## Modified BFS, correct
- the idea is to keep track of the cumulative time for each sub node and accumulate based on that when going down from it
```
public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();  // Build the hierarchical tree
        Deque<int[]> queue = new LinkedList<>();
        int result = Integer.MIN_VALUE;
        
        for(int i = 0; i < manager.length; i++) {
            if(!map.containsKey(manager[i]))
                map.put(manager[i], new ArrayList<>());
            
            map.get(manager[i]).add(i);     // Map of manager and its subordinates given by the index i
        }
        
        queue.offer(new int[]{headID, 0});      // head of organizer and corresponding informing time.
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int managerAtGivenLevel = temp[0];
            int cumulativeTime = temp[1];
            
            result = Math.max(result, cumulativeTime);
            
            if(map.containsKey(managerAtGivenLevel)) {      // if the manager has subordinates
                List<Integer> subordinates = map.get(managerAtGivenLevel);  // get the list of subordinates
            
                for(int i : subordinates) {
                    queue.offer(new int[]{i, informTime[managerAtGivenLevel] + cumulativeTime});    // add the subordinates as manager and the time taken to inform each of these subordinates
                }
            }
        }
        return result;
    }
```

## DFS
```
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) if (manager[i] != -1) graph[manager[i]].add(i);
        return dfs(graph, headID, informTime);
    }
    private int dfs(List<Integer>[] graph, int u, int[] informTime) {
        int ans = 0;
        for (int v : graph[u])
            ans = Math.max(ans, dfs(graph, v, informTime));
        return ans + informTime[u];
    }
```

## My backtracking
```
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
```
