class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return n;
        
		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int[] interval: intervals) {
            if (pq.isEmpty()) pq.add(interval[1]);
            else {
                if (interval[0] >= pq.peek()) pq.poll();
                pq.add(interval[1]);
            }
        }
        
        return pq.size();
    }
}