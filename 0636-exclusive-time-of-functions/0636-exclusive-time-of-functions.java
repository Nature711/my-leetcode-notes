class Solution {
    
  public static class LogEntry {
        private int functionId;
        private String event;
        private int timestamp;

        public LogEntry(int functionId, String event, int timestamp) {
            this.functionId = functionId;
            this.event = event;
            this.timestamp = timestamp;
        }

        public static LogEntry fromString(String log) {
            String[] parts = log.split(":");
            int functionId = Integer.parseInt(parts[0]);
            String event = parts[1];
            int timestamp = Integer.parseInt(parts[2]);
            return new LogEntry(functionId, event, timestamp);
        }

        public static Comparator<LogEntry> comparator = (le1, le2) -> {
            int cmp = Integer.compare(le1.timestamp, le2.timestamp);
            if (cmp != 0) {
                return cmp;
            }
            return le1.event.equals("start") ? -1 : 1;
        };

        @Override
        public String toString() {
            return functionId + ":" + event + ":" + timestamp;
        }
    }
        
    public int[] exclusiveTime(int n, List<String> logs) {
 
        int[] res = new int[n];
        Stack<LogEntry> stack = new Stack<>();

        for (String log : logs) {
            LogEntry logEntry = LogEntry.fromString(log);

            if (logEntry.event.equals("start")) {
                stack.push(logEntry);
            } else {
                LogEntry startEntry = stack.pop();
                int duration = logEntry.timestamp - startEntry.timestamp + 1;
                res[startEntry.functionId] += duration;
                
                if (!stack.isEmpty()) {
                    res[stack.peek().functionId] -= duration;
                }
            }
        }
        return res;
    }
}