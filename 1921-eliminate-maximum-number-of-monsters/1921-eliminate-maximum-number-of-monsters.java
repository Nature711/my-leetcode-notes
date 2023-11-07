class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((p, q) -> Double.compare((double) p.getKey() / p.getValue(), (double) q.getKey() / q.getValue())); 
        for (int i = 0; i < n; i++) {
            pq.add(new Pair<>(dist[i], speed[i]));
        }
        int t = 0;
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> p = pq.poll();
            int remDis = p.getKey() - t * p.getValue();
            if (remDis <= 0) return n - pq.size() - 1;
            t++;
        }
        return n;
    }
}