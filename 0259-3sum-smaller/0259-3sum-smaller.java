class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length;
        if (n < 2) return 0;
        
        Arrays.sort(nums);
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1;
            while (low < high) {
                int currSum = nums[i] + nums[low] + nums[high];
                if (currSum < target) {
                    count += high - low;
                    low++;
                } else high--;
            }
        }
        
        return count;
    }
}