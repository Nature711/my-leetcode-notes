class Solution {
    int m, n;
    int[][] grids;
    
    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        grids = grid;
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Find the first island and add its boundary to the queue
        boolean found = false;
        for (int i = 0; i < m && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, q);  // Mark the first island and add its boundary to the queue
                    found = true;
                }
            }
        }

        // Step 2: Perform BFS from the first island's boundary to find the shortest bridge
        int steps = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int currI = curr[0], currJ = curr[1];
                
                // Try all four directions
                for (int[] dir : dirs) {
                    int nextI = currI + dir[0];
                    int nextJ = currJ + dir[1];
                    
                    // Check if the next position is within bounds
                    if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
                        // If it's part of the second island, return the number of steps
                        if (grids[nextI][nextJ] == 1) return steps;
                        
                        // If it's water (0), add it to the queue for expansion and mark as visited
                        if (grids[nextI][nextJ] == 0) {
                            grids[nextI][nextJ] = -1;  // Mark as visited
                            q.add(new int[]{nextI, nextJ});
                        }
                    }
                }
            }
            steps++;
        }

        return -1;  // Shouldn't reach here
    }
    
    // Step 1: DFS to mark the first island and add its boundary to the BFS queue
    void dfs(int i, int j, Queue<int[]> q) {
        // Base condition: If out of bounds or if it's not land (1), return
        if (i < 0 || i >= m || j < 0 || j >= n || grids[i][j] != 1) return;
        
        grids[i][j] = -1;  // Mark this land as visited by changing it to -1
        q.add(new int[]{i, j});  // Add the current cell to the queue
        
        // Explore all four directions
        dfs(i + 1, j, q);
        dfs(i - 1, j, q);
        dfs(i, j + 1, q);
        dfs(i, j - 1, q);
    }
}
