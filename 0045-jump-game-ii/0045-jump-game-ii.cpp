class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        vector<int> memo(n, -1);
        return helper(nums, 0, memo);
    }
    
    int helper(vector<int>& nums, int start, vector<int>& memo) {
        if (memo[start] != -1) return memo[start];
        
        int n = nums.size();
        if (start == n - 1) return 0;
        
        int min_steps = nums.size();
        for (int i = 1; i <= nums[start]; i++) {
            if (start + i < n) {
                min_steps = min(min_steps, helper(nums, start + i, memo) + 1);
            }
        }
        memo[start] = min_steps;
        return min_steps;
    }
};