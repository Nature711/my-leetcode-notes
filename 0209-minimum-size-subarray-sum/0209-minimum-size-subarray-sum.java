class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        
        int[] prefixSums = new int[n + 1];
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            prefixSums[i + 1] = prefixSum;
        }
        
        int low = 0, high = 0, minLen = n + 1;
        
        while (low <= n && high <= n) {
            while (high <= n && prefixSums[high] - prefixSums[low] < target) high++;
            minLen = Math.min(minLen, high - low);
            low++;
        }
            
        return minLen > n ? 0 : minLen;
    }
}