class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                //see nums[i] for the first time
                nums[nums[i] - 1] = - Math.abs(nums[nums[i] - 1]); 
                //negative marking
                //take the absolute so that if it's already been marked 
                //(seen by someone else), we want to leave it negative (marked)
            } else {
                //nums[i] itself is negative, meaning it's seen by someone else
                nums[-nums[i] - 1] = - Math.abs(nums[-nums[i] - 1]);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) res.add(i + 1);
        }
        
        return res;
    }
}