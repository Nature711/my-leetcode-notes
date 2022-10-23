class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        int i = 1;
        int left = nums[0];
        
        while (i < nums.length - 1) {
            if ((nums[i] > left && nums[i] > nums[i + 1]) 
                || (nums[i] < left && nums[i] < nums[i + 1])) {
                //is hill or is valley
                left = nums[i];
                count++;

                i++;
//             } else if (nums[i] == nums[i + 1]) {
//                 int prev = nums[i - 1];
//                 int start = nums[i];
//                 while (i < nums.length && nums[i] == start) {
     
//                     i++;
//                 }
//                 if (i == nums.length) break;
//                 if ((prev > start && nums[i] > start) ||
//                     (prev < start && nums[i] < start)) {
//                     count++;
   
//                 }
            } else i++;
        }
        
        return count;
    }
}