class Solution {
public:
    int search(vector<int>& nums, int target) {
        int low = 0, high = nums.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid; //target found 
            if (nums[low] <= nums[mid]) { //left half [low...mid - 1] sorted 
                if (nums[low] <= target && target < nums[mid]) high = mid - 1; //target exists in sorted half
                else low = mid + 1; //target in other half
            } else { //right half [mid + 1...high] sorted
                if (nums[mid] < target && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
};