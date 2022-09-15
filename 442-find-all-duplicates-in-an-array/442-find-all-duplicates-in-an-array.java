class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int curr = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            curr = Math.abs(nums[i]) % n;
            if (nums[curr] < 0) res.add(curr == 0 ? n : curr);
            else nums[curr] = - nums[curr];
        }
        
        return res;
    }
}