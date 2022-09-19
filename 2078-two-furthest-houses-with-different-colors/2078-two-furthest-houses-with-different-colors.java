class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length, low = 0, maxDiff = 0, high = n - 1;
        
        while (low < n) {
            high = n - 1;
            if (maxDiff > high - low) break;
            while (low < high && colors[low] == colors[high]) {
                high--;
            }
            maxDiff = Math.max(maxDiff, high - low);
            low++;
        }
        
        return maxDiff;
    }
}