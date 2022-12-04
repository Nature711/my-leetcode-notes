class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        int m = image.length, n = image[0].length, srcColor = image[sr][sc];
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sr, sc});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                image[r][c] = color;
          
                for (int[] direction: directions) {
                    int nextR = r + direction[0];
                    int nextC = c + direction[1];
                    if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n  && image[nextR][nextC] == srcColor) { 
                        // System.out.println(nextR + " " + nextC);
                        queue.offer(new int[] {nextR, nextC});
                
                        
                    }
                }
            }
        }
        
        return image;
    }
}