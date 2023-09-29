class Solution {
public:
    bool isMonotonic(vector<int>& nums) {
        bool set = false;
        bool isIncreasing = false;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (!set) {
                if (nums[i] < nums[i + 1]) {
                    isIncreasing = true;
                    set = true;
                } else if (nums[i] > nums[i + 1]) {
                    isIncreasing = false;
                    set = true;
                }
            } else {
                if ((nums[i] < nums[i + 1] && !isIncreasing)
                    || (nums[i] > nums[i + 1] && isIncreasing)) {
                    return false;
                }
            }
        }
        return true;
    }
};