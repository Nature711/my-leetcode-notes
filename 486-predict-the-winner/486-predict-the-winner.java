class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[] scores = predict(nums, 0, nums.length - 1, 0, 0, 0);
        return scores[0] >= scores[1];
    }
    
    public int[] predict(int[] nums, int low, int high, int p0Score, int p1Score, int turn) {

        if (high == low) {
            if (turn == 0) return new int[]{p0Score + nums[low], p1Score};
            else return new int[]{p0Score, p1Score + nums[low]};
        }
                
        if (turn == 0) {
            int[] scoresIfChooseLeft = predict(nums, low + 1, high, p0Score + nums[low], p1Score, 1);
            int[] scoresIfChooseRight = predict(nums, low, high - 1, p0Score + nums[high], p1Score, 1);
            if (scoresIfChooseLeft[0] >= scoresIfChooseLeft[1]) return scoresIfChooseLeft;
            else return scoresIfChooseRight;
        } else {
            int[] scoresIfChooseLeft = predict(nums, low + 1, high, p0Score, p1Score + nums[low], 0);
            int[] scoresIfChooseRight = predict(nums, low, high - 1, p0Score, p1Score + nums[high], 0);
            if (scoresIfChooseLeft[1] >= scoresIfChooseLeft[0]) return scoresIfChooseLeft;
            else return scoresIfChooseRight;
        }
    } 
}