# Count Square Matrices With All Ones 

### Links
 - [Question](https://leetcode.com/problems/count-square-submatrices-with-all-ones/)
 - [Explanation 1](https://www.youtube.com/watch?v=Z2h3rkVXPeQ)
 - [Explanation 2](https://www.youtube.com/watch?v=GfGsM2G1tP8&t=0s)

## Solutions

### Without DP
- Idea: Use each entry in the matrix as the **top-left corner (starting point)** of a square; try to extend from that point to form square matrices of larger sides
- Time complexity: O(m * n * min(m * n))
  - m * n entries, each used once as the top-left corner (starting point) for extending
  - extending each corner involves checking if there is a square matrix, of side 1 up to the upper limit, starting at that corner
```
  public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = Math.min(m, n);
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; k < Math.min(n - j + 1, m - i + 1); k++) {
                    if (isSquare(matrix, i, j, k)) count++;
                    else break;
                }
            }
        }
        
        return count;
    }
    
    public boolean isSquare(int[][] matrix, int startI, int startJ, int side) {
        for (int j = startJ; j < startJ + side; j++) {
            if (matrix[startI + side - 1][j] == 0) return false;
        }
        for (int i = startI; i < startI + side; i++) {
            if (matrix[i][startJ + side - 1] == 0) return false;
        }
        return true;
    }
```

### DP solution 
- Idea: Use each entry in the matrix as the **bottom-right (ending point)** of a square
- dp[i][j] records the number of square matrices (of all possible sides) that ends at point [i,j]
- Important difference from previous: the computation of each dp[i][j] relies on the subproblems that are already solved
- Time complexity: O(m * n) 
  - m * n entries in dp table
  - O(1) for each entry
```
  public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) dp[i][0] = matrix[i][0];
        for (int j = 0; j < n; j++) dp[0][j] = matrix[0][j];
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) dp[i][j] = 0;
                else {
                    int min = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result += dp[i][j];
            }
        }
        return result;
    }
```

