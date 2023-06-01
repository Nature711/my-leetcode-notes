class Solution {
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1},
                             {1,1},{1,-1},{-1,1},{-1,-1}};
        LinkedList<int[]> q = new LinkedList<>();
        int[] start = new int[]{0, 0};
        if (grid[0][0] == 1) return -1;
        boolean[][] visited = new boolean[r][c];
        visited[0][0] = true;
        q.add(start);
        
        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if (curr[0] == r - 1 && curr[1] == c - 1) return steps;
                for (int[] dir: directions) {
                    int nextI = curr[0] + dir[0];
                    int nextJ = curr[1] + dir[1];
                    if (nextI >= 0 && nextI < r && nextJ >= 0 && nextJ < c) {
                        if (!visited[nextI][nextJ] && grid[nextI][nextJ] == 0) {
                            visited[nextI][nextJ] = true;
                            int[] next =  new int[]{nextI, nextJ};
                            q.add(next);
                        } 
                    } 
                }
            }
            steps++;
        }
        
        return -1;
        
        
    }
}