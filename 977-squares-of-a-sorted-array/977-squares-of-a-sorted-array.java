class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
       
        if (nums[0] < 0) {
            int turn = 0;
            while (turn < n && nums[turn] < 0) turn++;
            turn--;
            
            int low = 0;
            int high = turn;
            int temp = 0;
            while (low <= high) {
                temp = Math.abs(nums[low]);
                nums[low++] = Math.abs(nums[high]);
                nums[high--] = temp;
            }
            
            int pos = turn + 1;
            int neg = 0;
            int[] res = new int[n];
            int idx = 0;
        
            while (pos < n && neg <= turn) {
                if (nums[neg] < nums[pos]) res[idx++] = nums[neg++];
                else res[idx++] = nums[pos++];
            } 
            
            if (pos == n) {
                while (idx < n && neg <= turn) res[idx++] = nums[neg++];
            } 
            
            if (neg == turn + 1) {
                while (idx < n && pos < n) res[idx++] = nums[pos++];
            }
            
            for (int i = 0; i < n; i++) {
                res[i] = (int) Math.pow(res[i], 2);
            }
            return res;
            
        } else {
            for (int i = 0; i < n; i++) {
                nums[i] = (int) Math.pow(nums[i], 2);
            }
            return nums;
        }
    }
}