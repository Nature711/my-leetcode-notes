## Union find

- using the most optimla removal strategy, all stones sharing the same row / column are unioned into 1 single connected component 
- e.g.: 4 stones initially: (0,0), (0,2), (2,0), (2,2)
  - best removal strategy: (0,0) --> (0,2) --> (2,0) -- removed 3 stones, leaving only 1 stone (2,2)
  - worst removal strategy: (0,0) --> (2,2) -- removed 2 stones, leaving 2 stones (0,2), (2,0)
- observation: the best strategy tries to remove stones in a way such that successive removals consider stones that are in the same connected component (if possible)

```
  |
  2x       x
  |
  1   
  |x       x
  0—— 1 —— 2 ——
```

```
   public int removeStones(int[][] stones) {
        
        int n = stones.length;
        
        UnionFind uf = new UnionFind(n);
        
        Arrays.sort(stones, (s1, s2) -> {
            int diff = s1[0] - s2[0];
            return diff == 0 ? s1[1] - s2[1] : diff;
        });
        
        int low = stones[0][0], high = stones[n - 1][1];
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j && 
                    (stones[i][0] == stones[j][0] //share the same row
                    || stones[i][1] == stones[j][1])) //share the same column
                    uf.union(i, j);
                    // System.out.println(uf.numOfComponets);
            }
        }
        
        return n - uf.numOfComponets;
    }
 ```
