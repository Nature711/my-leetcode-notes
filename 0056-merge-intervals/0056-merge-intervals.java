class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        
        List<int[]> res = new ArrayList<>();
        int[] newInterval = intervals[0];
        int n = intervals.length;
        
        for (int i = 1; i <= n; i++) {
            while (i < n && intervals[i][0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            res.add(newInterval);
            if (i < n) newInterval = intervals[i];
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) result[i] = res.get(i);
        return result;
        
    }
}