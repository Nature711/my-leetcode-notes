class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (int i = 0; i < dist.length; i++) {
            pq.add((double) dist[i] / speed[i]);
        }
        double t = 1.00;
        int killed = 1;
        pq.poll();
        while (!pq.isEmpty()) {
            double arrival = pq.poll();
            if (arrival <= t) return killed;
            killed++;
            t++;
        }
        return killed;
    }
}