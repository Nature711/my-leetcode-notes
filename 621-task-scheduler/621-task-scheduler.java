class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character, List<Integer>> map = new HashMap<>();
        //map each task to a list --> (last execution time, no of such task remaining)
        HashSet<Character> remainingTasks = new HashSet<>();
        
        for (char task: tasks) {
            List<Integer> list;
            if (map.containsKey(task)) {
                list = map.get(task);
                list.set(1, list.get(1) + 1);
            } else {
                list = new ArrayList<>();
                list.add(-1);
                list.add(1);
            }
            map.put(task, list);
            remainingTasks.add(task);
        }
        
        int currTick = 0;
        
        while (!remainingTasks.isEmpty()) {
            Character currTask = null;
            int maxOccurence = 0;
            for (Character task: remainingTasks) {
                List<Integer> status = map.get(task);
                if (status.get(0) == -1 || (currTick - status.get(0)) > n) {
                    if (status.get(1) > maxOccurence) {
                        maxOccurence = status.get(1);
                        currTask = task;
                    }
                }
            }
            
            if (currTask != null) {
                List<Integer> status = map.get(currTask);
                status.set(0, currTick);
                int rem = status.get(1) - 1;
                status.set(1, rem);
                map.put(currTask, status);
                if (rem == 0) remainingTasks.remove(currTask);
            }
 
            currTick++;
        }
        
        return currTick;
    }
}