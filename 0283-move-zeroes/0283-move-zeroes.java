class Solution {
    public void moveZeroes(int[] nums) {
        int idx = removeElement(nums, 0);
        for (int i = idx; i < nums.length; i++) nums[i] = 0;
    }
    
    int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}