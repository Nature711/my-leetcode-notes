class Solution {
    public int search(int[] nums, int target) {
        
        int minIndex = findMinIndex(nums);
        
        int low, high;
        
        if (minIndex == 0) {
            low = 0;
            high = nums.length - 1;
        } else if (nums[0] <= target && target <= nums[minIndex - 1]) {
            low = 0;
            high = minIndex - 1;
        } else {
            low = minIndex;
            high = nums.length - 1;
        }
        
        //0 ... minIndex - 1 && minIndex ... high is sorted
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
        
    }
    
    public int findMinIndex(int[] nums) {
        int low = 0, high = nums.length - 1;
        if (low == high || nums[low] < nums[high]) return 0;
    
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1]) return mid + 1;
            if (nums[low] <= nums[mid]) {
                //left half sorted; turning point in right half
                low = mid;
            } else {
                //right half sorted; turning point in left half
                high = mid;
            }
        }
        return -1;
    }
  
}