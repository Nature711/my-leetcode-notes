class Solution {
    List<HashSet<Integer>> depends = new ArrayList<>();
    List<HashSet<Integer>> unlocks = new ArrayList<>();
    List<Integer> order = new ArrayList<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        for (int i = 0; i < numCourses; i++) {
            depends.add(new HashSet<>());
            unlocks.add(new HashSet<>());
        }
        
        for (int[] pre: prerequisites) {
            depends.get(pre[0]).add(pre[1]);
            unlocks.get(pre[1]).add(pre[0]);
        }
        
        Stack<Integer> coursesToTake = new Stack<>();
        for (int i = 0; i < numCourses; i++) if (depends.get(i).size() == 0) coursesToTake.push(i);
        
        while (!coursesToTake.isEmpty()) {
            int course = coursesToTake.pop();
            order.add(course);
            HashSet<Integer> unlockedCourses = unlocks.get(course);
            for (int unlock: unlockedCourses) {
                depends.get(unlock).remove(course);
                if (depends.get(unlock).size() == 0) coursesToTake.push(unlock);
            }
        }
        
        if (order.size() != numCourses) return new int[]{};
        int[] res = new int[numCourses];
        for (int i = 0; i < res.length; i++) res[i] = order.get(i);
        return res;
        
    }
   
}
    
