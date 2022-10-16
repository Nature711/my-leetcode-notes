class Solution {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> sums = new HashSet<>();
        
        for (int i = 0; i < n - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (!sums.add(sum)) return true;
        }
        
        return false;
    }
}