class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> res = new ArrayList<>();
        
        int i = 0, n = intervals.length;
        
        while (i < n && intervals[i][1] < newInterval[0]) res.add(intervals[i++]);
        
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);
        
        while (i < n) res.add(intervals[i++]);
        
        
        int[][] result = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) result[j] = res.get(j);
        return result;
    }
}