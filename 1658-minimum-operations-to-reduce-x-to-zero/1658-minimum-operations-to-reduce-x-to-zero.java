class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num: nums) sum += num;
        if (sum - x == 0) return nums.length;
        int max = maxSubArrayLen(nums, sum - x);
        return max == -1 ? max : nums.length - max;
    }
    
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cumuSum = 0;
        int maxLen = 0;
        map.put(0, 0);
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            cumuSum += nums[i];
            if (map.containsKey(cumuSum - k)) {
                found = true;
                maxLen = Math.max(maxLen, i + 1 - map.get(cumuSum - k));
            }
            if (!map.containsKey(cumuSum)) map.put(cumuSum, i + 1);
        }
        return found ? maxLen : -1;
    }
}