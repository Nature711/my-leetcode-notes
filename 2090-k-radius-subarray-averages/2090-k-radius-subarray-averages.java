class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        long[] prefix_sums = new long[n + 1];
        long prefix_sum = 0;
        for (int i = 0; i < n; i++) {
            prefix_sum += nums[i];
            prefix_sums[i + 1] = prefix_sum;
        }
        for (int i = 0; i < n; i++) {
            if (i - k < 0 || i + k >= n) res[i] = -1;
            else res[i] = (int) ((prefix_sums[i + 1 + k] - prefix_sums[i - k]) / (2 * k + 1));
        }
        return res;
    }
}