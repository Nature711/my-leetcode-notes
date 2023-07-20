class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) i--;
        
        if (i == 0) {
            reverseArray(nums, 0, n - 1);
        } else {
            int idx = binarySearchNextGreater(nums, i, n - 1, nums[i - 1]);
            
            int tmp = nums[i - 1];
            nums[i - 1] = nums[idx];
            nums[idx] = tmp;
            reverseArray(nums, i, n - 1);
        }
    }
    
    public void reverseArray(int[] nums, int low, int high) {
        while (low < high) {
            int tmp = nums[low];
            nums[low] = nums[high];
            nums[high] = tmp;
            low++;
            high--;
        }
    }
    
    public int binarySearchNextGreater(int[] nums, int low, int high, int target) {
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (nums[mid] > target) low = mid;
            else high = mid - 1;
        }
        return low;
    }
}