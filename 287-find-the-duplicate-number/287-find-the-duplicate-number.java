class Solution {
    public int findDuplicate(int[] nums) {
        
        int fast = nums[0];
        int slow = nums[0];
        
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }
        
        int ptr = nums[0];
        
        while (ptr != slow) {
            ptr = nums[ptr];
            slow = nums[slow];
        }
        
        return ptr;
    }
}