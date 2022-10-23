class Solution {
    public boolean isMonotonic(int[] nums) {
        int isIncreasing = 0;
        int isDecreasing = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (isDecreasing == 1) return false;
                else if (isIncreasing == 1) continue;
                else if (isIncreasing == 0) isIncreasing = 1;
            } else if (nums[i] < nums[i - 1]) {
                if (isIncreasing == 1) return false;
                else if (isDecreasing == 1) continue;
                else if (isDecreasing == 0) isDecreasing = 1;
            }
        }
        
        return true;
    }
}