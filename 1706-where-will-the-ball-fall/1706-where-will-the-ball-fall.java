class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int r = 0, c = i;
            while (r < m) {
                if (grid[r][c] == 1) {
                    if (c == n - 1 || grid[r][c + 1] == -1) {
                        res[i] = -1;
                        break;
                    } else {
                        r++;
                        c++;
                    }
                } else { //grid[r][c] == -1
                    if (c == 0 || grid[r][c - 1] == 1) {
                        res[i] = -1;
                        break;
                    } else {
                        r++;
                        c--;
                    }
                }
            }
            if (res[i] != -1) res[i] = c;
        }
        return res;
    }
}