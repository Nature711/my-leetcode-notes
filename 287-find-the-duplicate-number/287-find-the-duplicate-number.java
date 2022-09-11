class Solution {
    public int findDuplicate(int[] nums) {
        
        int i = nums[0];
        while (true) {
            if (nums[i] < 0) return i;
            nums[i] = - nums[i];
            i = Math.abs(nums[i]);
        }
        
    }
}