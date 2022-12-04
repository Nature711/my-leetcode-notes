## DFS

```
class Solution {
    int[][] globalImage;
    boolean[][] visited;
    int destColor, srcColor;
    int m, n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        globalImage = image;
        m = image.length;
        n = image[0].length;
        visited = new boolean[m][n];
        destColor = color;
        srcColor = image[sr][sc];
        dfs(sr, sc);
        return globalImage;
    }
    
    public void dfs(int r, int c) {
        if (r < 0 || r == m || c < 0 || c == n || visited[r][c] || globalImage[r][c] != srcColor) return;
        globalImage[r][c] = destColor;
        visited[r][c] = true;
        dfs(r - 1, c);
        dfs(r + 1, c);
        dfs(r, c - 1);
        dfs(r, c + 1);
    }
}
```

## BFS

- idea: start bfs (i.e., adding a point to queue) only if the point satisfies boundary condition and has the same color as ```srcColor```; during bfs we color a node to ```destColor``` only after polling it from queue 
- 
- point 0: to ake sure we don't run into infinite loop (otherwise if ```srcColor == destColor``` the check ```image[nextR][nextC] == srcColor``` will always be true
- point 1: don't need to color the starting node here since it will be colored when being polled out from queue (at point 2)
- point 2: color a node only after polling it from queue, since we have the checks at point 3 which makes sure any node that is added to queue must be a valid node -- valid in a sense that it must be colored; this early check also reduces operation overhead as we don't add unnecessary nodes to queue and check and throw them away later
- point 4: if we color here, we must make sure we color the starting node at point 1 as well -- otherwise the starting node won't be colored; alternatively we can just color at point 2 so that we don't need to worry about this

```
public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image[sr][sc] == color) return image; //point 0
        
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        int m = image.length, n = image[0].length, srcColor = image[sr][sc];
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sr, sc});
        //point 1
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                image[r][c] = color; //point 2
          
                for (int[] direction: directions) {
                    int nextR = r + direction[0];
                    int nextC = c + direction[1];
                    if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && image[nextR][nextC] == srcColor) { //point 3
                        queue.offer(new int[] {nextR, nextC});  
                        //point 4
                    }
                }
            }
        }
        
        return image;
    }
