class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            while (fast < nums.length && fast < nums.length && 
               nums[slow] >= nums[fast]) {
                fast++;
            }
            if (fast == nums.length) break;
            slow++;
            int tmp = nums[fast];
            nums[fast] = nums[slow];
            nums[slow] = tmp;
        }
        return slow + 1;
    }
}