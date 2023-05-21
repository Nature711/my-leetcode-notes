class Solution {
    Set<Integer> dfsVisited = new HashSet<>();
    int n;
    int[][] matrix;
    public int shortestBridge(int[][] grid) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        n = grid.length;
        matrix = grid;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                int curr = i * n + j;
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    flag = true;
                    break;
                }  
            }
            if (flag) break;
        }
        s1 = dfsVisited;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curr = i * n + j;
                if (grid[i][j] == 1 && !s1.contains(curr))
                    s2.add(curr);
            }
        }
        
        Set<Integer> starts = new HashSet<>();
        Set<Integer> targets = new HashSet<>();
        
        if (s1.size() < s2.size()) {
            starts = s1;
            targets = s2;
        } else {
            starts = s2;
            targets = s1;
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>(starts);
        for (int start: starts) {
            q.add(start);
        }
        
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean canReach = false;
            
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (targets.contains(curr)) return steps - 1;
                int r = curr / n, c = curr % n;
                int down = (r + 1) * n + c, up = (r - 1) * n + c, 
                    right = r * n + (c + 1), left = r * n + (c - 1);
                
                if (r + 1 < n && visited.add(down)) q.add(down);
                if (r - 1 >= 0 && visited.add(up)) q.add(up);
                if (c + 1 < n && visited.add(right)) q.add(right);
                if (c - 1 >= 0 && visited.add(left)) q.add(left);
            }
            steps++;
        }
        
        return steps;
    }
    
    public void dfs(int i, int j) {

        int curr = i * n + j;
        if (i < 0 || i == n || j < 0 || j == n || dfsVisited.contains(curr) || matrix[i][j] == 0) 
            return;
        
        dfsVisited.add(curr);
        
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
    
    
}