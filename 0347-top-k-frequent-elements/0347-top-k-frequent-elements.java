class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((p1, p2) -> p1.getValue() - p2.getValue());
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        for (int num: map.keySet()) {
            System.out.println(pq);
            int freq = map.get(num);
            pq.add(new Pair<>(num, freq));
            if (pq.size() > k) pq.poll();
        }
        
        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) res[i++] = pq.poll().getKey();
        
        return res;
    }
}