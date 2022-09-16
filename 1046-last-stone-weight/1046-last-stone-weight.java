class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for (int stone: stones) pq.add(stone);
        
        int x = 0;
        int y = 0;
        
        while (pq.size() >= 2) {
            y = pq.remove();
            x = pq.remove();
            if (x == y) continue;
            else pq.add(y - x);
        }
        
        if (pq.size() == 0) return 0;
        else return pq.remove();
        
    }
}