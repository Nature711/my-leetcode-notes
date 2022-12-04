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