class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        
        for (int num: nums) {
            maxHeap.add(num);
        }
        
        while (k > 1) {
            int num = maxHeap.poll();
            k--;
        }
        
        return maxHeap.poll();
    }
}