class Solution {
 
    public int[][] updateMatrix(int[][] mat) {
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
            
        }
        
        int cost = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                if (mat[r][c] == 1) res[r][c] = cost;
                
                for (int[] direction: directions) {
                    int nextR = r + direction[0];
                    int nextC = c + direction[1];
                    if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !visited[nextR][nextC]) { 
                        queue.offer(new int[] {nextR, nextC});
                        visited[nextR][nextC] = true;
                    }
                }
            }
        cost++;  
        }
        
        return res;
    }
    
}