class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m * n - 1;
        int r = 0, c = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            r = mid / n;
            c = mid % n;
            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] < target) {
                low = mid + 1;
            } else high = mid - 1;
        }
        
        return false;
    }
}