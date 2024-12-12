class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int gift: gifts) pq.add(gift);
        while (k > 0) {
            int g = pq.poll();
            int r = (int) (Math.floor(Math.sqrt(g)));
            pq.add(r);
            k--;
            //System.out.println(pq);
        }
        long sum = 0;
        while (!pq.isEmpty()) sum += pq.poll();
        return sum;
    }
}