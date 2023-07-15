class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));
        
        int minEnd = Integer.MIN_VALUE, removalCount = 0;
        
        for (int[] interval: intervals) {
            if (interval[0] >= minEnd) { //no overlap
                minEnd = interval[1]; //update minEnd
                //no removal needed
            } else { //overlap
                minEnd = Math.min(interval[1], minEnd);
                //remove the longer interval (either the one associated with current minEnd or the current interval)
                removalCount++;
            }
        }
        
        return removalCount;
    }
}