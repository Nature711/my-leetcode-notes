class Solution {
    public int smallestCommonElement(int[][] mat) {
        for (int i = 0; i < mat[0].length; i++) {
            boolean bool = true;
            for (int j = 1; j < mat.length; j++) {
                if (!binarySearch(mat[j], mat[0][i])) {
                    bool = false;
                    break;
                }
            }
            if (bool) return mat[0][i];
        }
        return -1;
    }
    
    public boolean binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}