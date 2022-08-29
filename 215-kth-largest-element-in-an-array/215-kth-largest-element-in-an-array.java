class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num: nums) {
            minHeap.add(num);
        }
        
        int count = nums.length - k + 1;
        while (count > 1) {
            minHeap.poll();
            count--;
        }
        
        return minHeap.poll();
    }
}