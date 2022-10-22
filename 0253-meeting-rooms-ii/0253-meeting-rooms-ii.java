class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return n;
        
		int[] starts = new int[n];
        int[] ends = new int[n];
        
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int s_ptr = 1;
        int e_ptr = 0;
        int count = 1;
        
        while (s_ptr < n) {
            if (starts[s_ptr] < ends[e_ptr]) count++;
            else e_ptr++;
            s_ptr++;
        }
        
        return count;
        
    }
}