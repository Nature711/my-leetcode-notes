class Solution {
    public void moveZeroes(int[] nums) {
        int ptr = 0;
        while (ptr < nums.length) {
            if (nums[ptr] == 0) {
                int guide = ptr + 1;
                while (guide < nums.length && nums[guide] == 0) guide++;
                if (guide < nums.length) {
                    nums[ptr] = nums[guide];
                    nums[guide] = 0;
                }
            }
            ptr++;
        }
    }
}