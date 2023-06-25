class Solution {
    int[] locs;
    int[][] memo;
    
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        locs = locations;
        memo = new int[locations.length][fuel + 1];
        for (int i = 0; i < locations.length; i++) Arrays.fill(memo[i], -1);
        return dfs(start, finish, fuel);
    }
    
    public int dfs(int start, int finish, int fuelLeft) {
        if (fuelLeft < 0) return 0;
        
        if (memo[start][fuelLeft] != -1) return memo[start][fuelLeft];
        
        // if (start == finish) return 1;
 
        int count = start == finish ? 1 : 0;
        
        for (int i = 0; i < locs.length; i++) {
            if (i == start) continue;
            int distance = Math.abs(locs[start] - locs[i]);
            count = (count + dfs(i, finish, fuelLeft - distance)) % 1000000007;
        }
        
        memo[start][fuelLeft] = count;
        return count;
    }
}