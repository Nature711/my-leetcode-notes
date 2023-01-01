class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int overlapped = 0, n = timeSeries.length;
        for (int i = 0; i < n - 1; i++) 
            overlapped += Math.max(0, (timeSeries[i] + duration - timeSeries[i + 1]));
        return n * duration - overlapped;
    }
}