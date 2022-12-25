class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        max = Math.max(max, nums[0] * nums[1] * nums[n - 1]);
        max = Math.max(max, nums[0] * nums[1] * nums[2]);
        max = Math.max(max, nums[0] * nums[n - 2] * nums[n - 1]);
        max = Math.max(max, nums[n - 3] * nums[n - 2] * nums[n - 1]);
        return max;
    }
}