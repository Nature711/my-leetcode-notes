class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length; 
        int low = 0;
        int high = n - 1;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        for (int i = 0; i < n; i++) {
            leftSum[i] = nums[i] + (i == 0 ? 0 : leftSum[i - 1]);
            rightSum[n - 1 - i] = nums[n - 1 - i] + (i == 0 ? 0: rightSum[n - i]);
        }
        
        for (int i = 0; i < n; i++) {
            if (leftSum[i] == rightSum[i]) return i;
        }
        
        return -1;
    }
}