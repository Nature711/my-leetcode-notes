class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[] res = getScores(0, nums.length - 1, 1, nums);
        return res[0] >= res[1];
    }
    
    public int[] getScores(int start, int end, int turn, int[] nums) {
        int[] res = new int[2];
        
        if (start == end) {
            if (turn == 1) {
                res[0] = nums[start];
                res[1] = 0;
            } else {
                res[0] = 0;
                res[1] = nums[start];
            }
            return res;
        } else {
            if (turn == 1) {
                int[] res1 = getScores(start + 1, end, 2, nums);
                int[] res2 = getScores(start, end - 1, 2, nums);
                if (res1[1] < res2[1]) {
                    res[0] = nums[start] + res1[0];
                    res[1] = res1[1];
                } else {
                    res[0] = nums[end] + res2[0];
                    res[1] = res2[1];
                }
            } else {
                int[] res1 = getScores(start + 1, end, 1, nums);
                int[] res2 = getScores(start, end - 1, 1, nums);
                if (res1[0] < res2[0]) {
                    res[1] = nums[start] + res1[1];
                    res[0] = res1[0];
                } else {
                    res[1] = nums[end] + res2[1];
                    res[0] = res2[0];
                }
            }
        }
        return res;
    }
}