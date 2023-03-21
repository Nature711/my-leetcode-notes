class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long[] cumuSum = new long[n + 1];
        cumuSum[0] = 0;
        for (long i = 1; i <= n; i++) cumuSum[(int) i] = cumuSum[(int) (i - 1)] + i;
        int i = 0;
        long total = 0;
        while (i < n) {
            int currLen = 0;
            while (i < n && nums[i] == 0) {
                i++;
                currLen++;
            }
            total += cumuSum[currLen];
            i++;
        }
        return total;
    }
}