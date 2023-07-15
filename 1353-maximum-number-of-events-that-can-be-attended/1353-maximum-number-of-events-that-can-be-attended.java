class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (e1, e2) ->  e1[0] - e2[0]);
        int eventCount = 0, eventId = 0;
        PriorityQueue<int[]> openEvents = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        
        for (int d = 1; d <= 100000; d++) {
            while (!openEvents.isEmpty() && (openEvents.peek())[1] < d) openEvents.poll();
            while (eventId < events.length && events[eventId][0] == d) {
                //add all events that start on day d
                openEvents.add(events[eventId++]);
            } 
            if (!openEvents.isEmpty()) {
                openEvents.poll();
                eventCount++;
            }
            
        }
        
        return eventCount;
    }

}