public class Solution {
    public int minimizeArrayValue(int[] nums) {
        double sum = nums[0];
        double result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            
            result = Math.max(result, (int) Math.ceil(sum / (i + 1)));
            
        }
        return (int) result;
    }
}