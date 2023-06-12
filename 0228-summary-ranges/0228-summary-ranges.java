class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length, i = 0;
        List<String> res = new ArrayList<>();
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[j] - nums[j - 1] == 1) j++;
            String interval = Integer.toString(nums[i]);
            if (j - 1 > i) {
                interval += "->" + Integer.toString(nums[j - 1]);
            }
            res.add(interval);
            i = j;
        }
        return res;
    }
}