class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int negCount = 0;
        for (int i = m - 1; i >= 0; i--) {
            if (grid[i][n - 1] > 0) continue;
            int idx = binarySearch(0, n - 1, grid[i]);
            negCount += (idx == -1 ? 0 : (n - idx));
        }
        return negCount;
    }
    
    
    
    public int binarySearch(int low, int high, int[] arr) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < 0) high = mid;
            else low = mid + 1;
        }
        
        return arr[low] < 0 ? low : -1;
    }
}