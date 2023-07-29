class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int total = 0;
        for (int num: nums) total += num;
        int player1Score = minimax(0, nums.length - 1, 1, nums, total);
        
        return player1Score >= (total - player1Score);
    }
    
    public int minimax(int start, int end, int turn, int[] nums, int total) {
      
        if (start == end) {
            if (turn == 1) return nums[start];
            else return 0;
        }
        
        if (turn == 1) {
            int left = nums[start] + minimax(start + 1, end, 2, nums, total);
            int right = nums[end] + minimax(start, end - 1, 2, nums, total);
        
            return Math.max(left, right);
        } else {
            int left = minimax(start + 1, end, 1, nums, total);
            int right = minimax(start, end - 1, 1, nums, total);
           
            return Math.min(left, right);
        }
    }
}