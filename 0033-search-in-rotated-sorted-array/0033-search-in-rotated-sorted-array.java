class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[low] <= nums[mid]) {
                //left side sorted
                if (target >= nums[low] && target <= nums[mid]) {
                    //target within left sorted side, apply regular binary search
                    high = mid - 1;
                } else low = mid + 1;
            } else {
                //right side sorted
                if (target >= nums[mid] && target <= nums[high]) {
                    //target within left sorted side, apply regular binary search
                    low = mid + 1; 
                } else high = mid - 1;
            }
        }
        
        return -1;
    }
}