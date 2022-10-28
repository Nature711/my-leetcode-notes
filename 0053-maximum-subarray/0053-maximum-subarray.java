class Solution {
    int[] numss;
    public int maxSubArray(int[] nums) {
        numss = nums;
        return solver(0, nums.length - 1);
    }
    
    public int solver(int low, int high) {
        if (high < low) return Integer.MIN_VALUE;
        
        int mid = Math.floorDiv(low + high, 2);
       
        int leftMax = 0, leftSum = 0, rightMax = 0, rightSum = 0;
        for (int i = mid - 1; i >= low; i--) {
            leftSum += numss[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        for (int i = mid + 1; i <= high; i++) {
            rightSum += numss[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        int left = solver(low, mid - 1);
        int right = solver(mid + 1, high);
        return Math.max((leftMax + rightMax + numss[mid]), Math.max(left, right));
    }
}