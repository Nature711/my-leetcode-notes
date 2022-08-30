class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((p1, p2) -> p1.getKey() - p2.getKey());
        
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int distance = point[0] * point[0] + point[1] * point[1];
            pq.add(new Pair<>(distance, i));
        }
        
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            Pair<Integer, Integer> p = pq.poll();
            res[i] = points[p.getValue()];
        }
        
        return res;
    }
}