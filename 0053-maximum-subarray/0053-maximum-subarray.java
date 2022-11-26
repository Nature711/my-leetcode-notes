class Solution {
    
    int[] globalNums;
    public int maxSubArray(int[] nums) {
        globalNums = nums;
        return helper(0, nums.length - 1);
    }
    
    public int helper(int low, int high) {
        if (low == high) return globalNums[low];
        
        int mid = low + (high - low) / 2;
        int leftMax = helper(low, mid);
        int rightMax = helper(mid + 1, high);
        
        int currSumLeft = 0, maxFromLeft = 0, currSumRight = 0, maxFromRight = 0;
        
        for (int i = mid - 1; i >= low; i--) {
            currSumLeft += globalNums[i];
            maxFromLeft = Math.max(maxFromLeft, currSumLeft);
        }
        for (int i = mid + 1; i <= high; i++) {
            currSumRight += globalNums[i];
            maxFromRight = Math.max(maxFromRight, currSumRight);
        }
        
        int middleMax = globalNums[mid] + maxFromLeft + maxFromRight;
    
        return Math.max(leftMax, Math.max(rightMax, middleMax));
    }
    
}