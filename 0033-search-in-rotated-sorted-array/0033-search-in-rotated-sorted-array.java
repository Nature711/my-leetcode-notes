class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) { // left part sorted
                if ((nums[0] <= target) && (target < nums[mid])) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // right part sorted
                if ((nums[mid] < target) && (target <= nums[high])) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        if (nums[low] == target) return low;
        return -1;
    }
}