class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE, n = nums.length;
        int winStart = 0, winEnd = 0;
        int currSum = 0;
        while (winEnd < n) {
            currSum += nums[winEnd];
            while (currSum >= target) {
                minLen = Math.min(minLen, winEnd - winStart + 1);
                currSum -= nums[winStart];
                winStart++;
            }
            winEnd++;
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}