class Solution {
    public boolean isBipartite(int[][] graph) {
        boolean[] isColored = new boolean[graph.length];
        Set<Integer> visited = new HashSet<>();
        for (int n = 0; n < graph.length; n++) {
            if (!visited.contains(n)) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(n);
                visited.add(n);
                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int i = 0; i < size; i++) {
                        int curr = q.poll();
                        for (int nei: graph[curr]) {
                            if (!visited.contains(nei)) {
                                q.offer(nei);
                                visited.add(nei);
                                isColored[nei] = !isColored[curr];
                            } else {
                                if (isColored[nei] == isColored[curr]) return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}