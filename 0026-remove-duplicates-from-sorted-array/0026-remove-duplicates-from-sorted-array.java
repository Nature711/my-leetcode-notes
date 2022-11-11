class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = nums[0], i = 1, uniqueCount = 1;
        while (i < nums.length) {
            while (i < nums.length && nums[i] == curr) nums[i++] = 101;         
            if (i < nums.length) {
                curr = nums[i++];
                uniqueCount++;
            }
        } 
        
        i = 0; 
        int tempIdx = 0, count = 0;
        while (count < uniqueCount) {
            if (nums[i] == 101) {
                tempIdx = count;
                while (i < nums.length && nums[i] == 101) i++;
                if (i < nums.length) {
                    nums[tempIdx] = nums[i];
                    nums[i] = 101;
                    count++;
                }
            } else {
                count++;
                i++;
            }
        }

        return uniqueCount;
    }
}