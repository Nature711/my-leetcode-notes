## Meeting rooms
- sort intervals by ascending starting time
- determine if there's any overlapping intervals
```
   public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) return true;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }
        
        return true;
    }
```

## Meeting rooms 2
- sort intervals by ascending starting time
- iterate over sorted interval; need to open up a new room if the current meeting's starting time is earlier than any of the existing meetings' ending time
  --> i.e., earlier than the earliest ending time of all existing meetings
  --> idea: maintain a set of existing meetings' ending times; every time we only care about the earliest among them --> use a min heap!
```
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
 ```

## Merge intervals

```
public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {                             // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}

		return result.toArray(new int[result.size()][]);
	}
```
