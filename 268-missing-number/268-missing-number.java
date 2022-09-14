class Solution {
    public int missingNumber(int[] nums) {
        int[] marks = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            marks[nums[i]] = 1;
        }
        
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] == 0) return i;
        }
        
        return 0;
    }
}