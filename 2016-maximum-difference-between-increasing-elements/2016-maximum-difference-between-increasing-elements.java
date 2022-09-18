class Solution {
    public int maximumDifference(int[] nums) {
        int low = 0, high = 1, max = -1;
        
        while (high < nums.length) {
            while (high < nums.length && nums[high] > nums[low]) {
                max = Math.max(max, nums[high] - nums[low]);
                high++;
            }
            low = high;
            high++;
        }
        
        return max;
    }
}