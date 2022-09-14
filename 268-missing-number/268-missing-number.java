class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;
        int num = n + 1;
        
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums[i]) == n) continue;
            else if (nums[Math.abs(nums[i])] == 0) num = Math.abs(nums[i]);
            else nums[Math.abs(nums[i])] = - nums[Math.abs(nums[i])];
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (num != i) return i;
            }
            if (nums[i] > 0) return i;
        }
        
        return n;
    }
}