class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        
        Pair<Integer, Integer>[][] map = new Pair[n][n];
        
        long ans = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) map[i][j] = new Pair<>(nums[i], nums[i]);
                else {
                    Pair<Integer, Integer> minMax = map[i][j - 1];
                    int min = minMax.getKey();
                    int max = minMax.getValue();
                    if (nums[j] > max) max = nums[j];
                    if (nums[j] < min) min = nums[j];
                    map[i][j] = new Pair<>(min, max);
                    ans += (max - min);
                }
            }
        }
        
        return ans;
    }
}