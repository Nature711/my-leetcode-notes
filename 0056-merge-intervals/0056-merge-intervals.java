class Solution {
    public int[][] merge(int[][] intervals) {
        
        if (intervals.length == 1) return intervals;
        
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        
        List<int[]> res = new ArrayList<>();
        int[] newInterval = intervals[0];
        res.add(newInterval);
        
        for (int[] interval: intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                res.add(newInterval);
            }
        }
        
        return res.toArray(new int[res.size()][2]);
    }
}