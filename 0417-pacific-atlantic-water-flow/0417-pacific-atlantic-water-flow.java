class Solution {
    int[][] canFlowToPacific, canFlowToAtlantic, allHeights;
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        allHeights = heights;
        m = heights.length;
        n = heights[0].length;
        canFlowToPacific = new int[m][n];
        canFlowToAtlantic = new int[m][n];
        List<List<Integer>> results = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            dfs(0, j, -1, 0, new boolean[m][n]);
            dfs(m - 1, j, -1, 1, new boolean[m][n]);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, 0, -1, 0, new boolean[m][n]);
            dfs(i, n - 1, -1, 1, new boolean[m][n]);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canFlowToPacific[i][j] == 1 && canFlowToAtlantic[i][j] == 1) {
                    List<Integer> res = new ArrayList<>();
                    res.add(i);
                    res.add(j);
                    results.add(res);
                }
            }
        }
        return results;
        
    }
    
    public void dfs(int r, int c, int preHeight, int src, boolean[][] visited) {
        if (r < 0 || r == m || c < 0 || c == n || preHeight > allHeights[r][c] || visited[r][c]) return;
        
        if (src == 0) canFlowToPacific[r][c] = 1;
        else canFlowToAtlantic[r][c] = 1;
        visited[r][c] = true;
        
        dfs(r + 1, c, allHeights[r][c], src, visited);
        dfs(r - 1, c, allHeights[r][c], src, visited);
        dfs(r, c + 1, allHeights[r][c], src, visited);
        dfs(r, c - 1, allHeights[r][c], src, visited);
    }
}