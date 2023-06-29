class Solution {
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Pair<Integer, Integer>, Double> edgeWeights = new HashMap<>();
        double[] maxProb = new double[n];
        maxProb[start] = 1d;
        
        PriorityQueue<Pair<Integer, Double>> pq = 
            new PriorityQueue<>((p1, p2) -> Double.compare(p2.getValue(), p1.getValue()));
        //each pair is (nodeId, minDistanceFromSource)
        //node with smaller distance from source has higher priority

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (graph.containsKey(edge[0])) {
                graph.get(edge[0]).add(edge[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edge[1]);
                graph.put(edge[0], list);
            }
            if (graph.containsKey(edge[1])) {
                graph.get(edge[1]).add(edge[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edge[0]);
                graph.put(edge[1], list);
            }
            edgeWeights.put(new Pair<>(edge[0], edge[1]), succProb[i]);
            edgeWeights.put(new Pair<>(edge[1], edge[0]), succProb[i]);
            pq.add(new Pair<>(i, (i == start) ? 1d : 0.00));
        }
        
        
        
        while (!pq.isEmpty()) {
            //System.out.println(pq);
            Pair<Integer, Double> p = pq.poll();
            int node = p.getKey();
            double currDistance = p.getValue();
            if (!graph.containsKey(node)) continue;
            List<Integer> neighbors = graph.get(node);
            if (node == end) return currDistance;
            for (int nei: neighbors) {
                Pair<Integer, Integer> edge = new Pair<>(node, nei);
                double weight = edgeWeights.get(edge);
                double tempDistance = currDistance * weight;
                if (tempDistance > maxProb[nei]) {
                    maxProb[nei] = tempDistance;
                    pq.add(new Pair<>(nei, tempDistance));
                }
            }
        }
        
        return 0d;
    }
}