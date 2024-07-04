class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] == 0) {
                if (nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    nums[fast] = 0;
                } else {
                    fast++;
                }
            }
            if (nums[slow] != 0) {
                slow++;
                fast = slow;
            }
        }
    }
}