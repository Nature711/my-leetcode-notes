class Solution {

    public int maximumProduct(int[] nums, int k) {
           
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //min heap by default
        
        for (int num: nums) pq.add(num);
        
        while (k-- > 0) pq.add(pq.poll() + 1);
        
        long currProd = 1;
        
        while (!pq.isEmpty()) currProd = (long) ((pq.poll() * currProd) % (Math.pow(10, 9) + 7));
        
        return (int) (currProd % (Math.pow(10, 9) + 7));
    }
 
}