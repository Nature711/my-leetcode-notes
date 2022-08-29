class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((p1, p2) -> p1.getKey() - p2.getKey());
        
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new Pair<>(nums[i], i));
            if (minHeap.size() > k) minHeap.poll();
        }
        
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((p1, p2) -> p1.getValue() - p2.getValue());
        
        for (int i = 0; i < k; i++) {
            Pair<Integer, Integer> p = minHeap.poll();
            pq.add(p);
        }
        
        int[] res = new int[k];
        
        for (int i = 0; i < k; i++) {
            Pair<Integer, Integer> p = pq.poll();
            res[i] = p.getKey();
        }
        
        return res;
        
    }
}