class Solution {
    int tick = 0;
    int[][] oranges;
    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    Set<Integer> fresh = new HashSet<>();
    
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        oranges = grid;
        boolean[][] visited = new boolean[m][n];
                
        Queue<int[]> queue = new LinkedList<>();
        

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (oranges[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (oranges[i][j] == 1) fresh.add(n * i + j);
                
            }
        }
        
        if (fresh.size() == 0) return 0; //no fresh
        if (queue.size() == 0) return -1; //no rotten

        
        // queue.offer(start);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                fresh.remove(orange);
                int r = orange[0];
                int c = orange[1];
                fresh.remove(n * r + c);
                if (fresh.size() == 0) return tick;
                
                for (int[] direction: directions) {
                    int nextR = r + direction[0];
                    int nextC = c + direction[1];
                    if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !visited[nextR][nextC] && oranges[nextR][nextC] == 1) { 
                        queue.offer(new int[] {nextR, nextC});
                        visited[nextR][nextC] = true;
                    }
                }
            }
            tick++;
        }
        
        return fresh.size() == 0 ? tick : -1;
    }
}