class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        
        int left = 0;
        int right = n - 1;
        int[] ans = new int[n];
        
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (nums[i] < pivot) ans[left++] = nums[i];
            if (nums[j] > pivot) ans[right--] = nums[j];
        }
        
        while (left <= right) ans[left++] = pivot;
        
        return ans;
    }
}