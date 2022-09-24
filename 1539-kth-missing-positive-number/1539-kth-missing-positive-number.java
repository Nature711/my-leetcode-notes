class Solution {
    public int findKthPositive(int[] arr, int k) {
        int len = arr.length;
        int noOfMissing = arr[len - 1] - len;
        if (k > noOfMissing) return arr[len - 1] + (k - noOfMissing);
        
        int low = 0; 
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2; 
            if (arr[mid] - mid - 1 < k) low = mid + 1;
            else high = mid;
        }
        
        return arr[high] + (k - (arr[high] - high));
    }
}