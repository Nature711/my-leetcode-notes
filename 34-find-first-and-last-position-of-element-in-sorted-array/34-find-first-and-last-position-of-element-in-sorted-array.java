class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        
        int l = 0, r = nums.length - 1;
        
        int[] ans = new int[]{-1, -1};
        
        if (n == 0) return ans;
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        
        if (nums[l] != target) return new int[]{-1, -1};
        
        ans[0] = l;
        
        l = 0;
        r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        
        ans[1] = l;
        
        return ans;
        
    }
}