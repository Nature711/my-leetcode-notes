## DP (Accepted)
```
   2
  3 4
 6 5 7
4 1 8 3
```
- dp[i][j] = sum of min sum path with node[i][j] as starting node
- intializing from the leaf nodes
- building from bottom to top -- each dp[i][j] asks its bottom-left and bottom-right node, then adding itself to sum

```
   public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int currWidth = triangle.get(height - 1).size();
    
        int[][] dp = new int[height][currWidth];
        
        for (int i = 0; i < currWidth; i++) {
            dp[height - 1][i] = triangle.get(height - 1).get(i);
        }
        
        for (int i = height - 2; i >= 0; i--) {
            currWidth = i + 1;
            for (int  j = 0; j < currWidth; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        
        return dp[0][0];                         
    }
 ```
 
 ## DFS (TLE)
 ```
  int currMinSum = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        
        List<Integer> sum = new ArrayList<>();
        sum.add(0);
        
        dfs(triangle, new ArrayList<>(), sum, 0);
        
        return currMinSum;
    }
    
    public void dfs(List<List<Integer>> triangle, List<Integer> currPath,
                   List<Integer> currSum, int currIdx) {
        
        if (currIdx >= 0 && currIdx < triangle.size()) {

            int val = triangle.get(currPath.size()).get(currIdx);
            currPath.add(val);
            currSum.set(0, currSum.get(0) + val);
            // System.out.println(currPath);
            // System.out.println(currSum.get(0));
            if (currPath.size() == triangle.size()) {
                currMinSum = Math.min(currMinSum, currSum.get(0));
            } else {
                dfs(triangle, currPath, currSum, currIdx);
                dfs(triangle, currPath, currSum, currIdx + 1);
            }
            currPath.remove(currPath.size() - 1);
            currSum.set(0, currSum.get(0) - val);
        }
        
    }
 ```
