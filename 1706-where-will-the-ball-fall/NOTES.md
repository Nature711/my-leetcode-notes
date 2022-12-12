## Key intuition
- The ball can move into the next row from the current cell if and only if the adjacent column has the same value

## iterative simulation 
```
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
 ```
 
 ## DFS
 ```
  public int[] findBall(int[][] grid) {
        int result[] = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            result[i] = findBallDropColumn(0, i, grid);
        }
        return result;
    }

    public int findBallDropColumn(int row, int col, int[][] grid) {
        // base case; ball reached the last row
        if (row == grid.length)
            return col;
        int nextColumn = col + grid[row][col];
        if (nextColumn < 0 ||
                nextColumn > grid[0].length - 1 ||
                grid[row][col] != grid[row][nextColumn]) {
            return -1;
        }
        return findBallDropColumn(row + 1, nextColumn, grid);
    }
 ```
