class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cumuSum = 0;
        int maxLen = 0;
        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            cumuSum += nums[i];
            if (map.containsKey(cumuSum - k)) maxLen = Math.max(maxLen, i + 1 - map.get(cumuSum - k));
            if (!map.containsKey(cumuSum)) map.put(cumuSum, i + 1);
        }
        return maxLen;
    }
}