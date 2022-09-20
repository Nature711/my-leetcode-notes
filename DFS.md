## Matrix (4 directions)
```
main(matrix) {
    for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrx[0].length; j++) {
              if (<some_condition>) dfs(i, j, matrix); //enter and search matrix from index (i,j)
          }
     }
}

dfs(i, j, matrix) {
    if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || <terminating_condition>) return;
    //out of bounds / hitting terminating condition
        
    matrix[i][j] = 0; //mark current grid as visited
    
    //searching each of the 4 directions 
    dfs(i + 1, j, grid);
    dfs(i, j + 1, grid);
    dfs(i - 1, j, grid);
    dfs(i, j - 1, grid);

    return;
}
```

## Examples 
- [Number of Islands](https://leetcode.com/problems/number-of-islands/)
  - DFS simplies marks visited grids; returning void
  - Count the number of DFS done
- [Max Area of Island](https://leetcode.com/problems/max-area-of-island/)
  - DFS returns the size of area 
  - Find the max area after DFSing all areas
