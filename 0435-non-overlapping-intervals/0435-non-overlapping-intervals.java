class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int maxEnd = intervals[0][1];
        int removeCount = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < maxEnd) {
                removeCount++;
                maxEnd = Math.min(maxEnd, intervals[i][1]);
            } else {
                maxEnd = intervals[i][1];
            }
        }
        return removeCount;
    }
}