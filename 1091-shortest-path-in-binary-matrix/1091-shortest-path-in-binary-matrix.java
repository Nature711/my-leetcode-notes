class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[n - 1][n - 1] == 1) return -1;
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[] start = new int[]{n - 1, n - 1};
        queue.offer(start);
        int cost = 1;
        int i = 0, j = 0, nextI = 0, nextJ = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] coordinate = queue.poll();
            
                i = coordinate[0];
                j = coordinate[1];
                // visited[i][j] = true;
            
                if (i == 0 && j == 0 && grid[0][0] == 0) return cost;
                
                for (int[] direction: directions) {
                    nextI = i + direction[0];
                    nextJ = j + direction[1];
                    int[] next = new int[] {nextI, nextJ};
                    if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < n && grid[nextI][nextJ] == 0 && !visited[nextI][nextJ]) {
                        queue.offer(next);
                        visited[nextI][nextJ] = true;
                    }
                }
            }
            cost++;
        }
        
        return -1;
    }
}