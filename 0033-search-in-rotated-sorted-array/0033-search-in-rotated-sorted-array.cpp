class Solution {
public:
    int search(vector<int>& nums, int target) {
        if (nums[0] <= nums[nums.size() - 1]) {
            return binarySearch(nums, 0, nums.size() - 1, target);
        } else {
            int turn = findTurningPoint(nums);
            //cout << "turn " << turn << endl;
            int idx = binarySearch(nums, 0, turn, target);
            if (idx != -1) return idx;
            else return binarySearch(nums, turn + 1, nums.size() - 1, target);
        }
    }
    
    int binarySearch(vector<int>& nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    
    int findTurningPoint(vector<int>& nums) {
        int low = 0, high = nums.size() - 1;
        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            //cout << "mid " << mid << endl;
            if (nums[mid] > nums[mid + 1]) return mid;
            else if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        return low;
    }
};