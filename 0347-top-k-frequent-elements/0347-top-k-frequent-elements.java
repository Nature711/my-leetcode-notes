class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair<Integer, Integer>> pq = 
            new PriorityQueue<>((p1, p2) -> p2.getValue() - p1.getValue());
        for (int key: countMap.keySet()) pq.add(new Pair<>(key, countMap.get(key)));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}