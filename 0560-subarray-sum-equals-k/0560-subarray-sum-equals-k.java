class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int cumuSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            cumuSum += nums[i];
            if (map.containsKey(cumuSum - k)) {
                count += map.get(cumuSum - k);
            }
            map.put(cumuSum, map.getOrDefault(cumuSum, 0) + 1);
        }
        
        return count;
    }
}