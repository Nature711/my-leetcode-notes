class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] minBeforeJ = new int[n];
        minBeforeJ[0] = nums[0];
        for (int i = 1; i < n; i++) minBeforeJ[i] = Math.min(nums[i], minBeforeJ[i - 1]);
        Stack<Integer> stack = new Stack<>();
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[j] > stack.peek()) {
                if (minBeforeJ[j] < stack.peek()) return true;
                stack.pop();
            }
            stack.push(nums[j]);
        }
        return false;
    }
}