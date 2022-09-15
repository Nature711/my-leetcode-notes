class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
        int index = 0;
        
        for (int i = 0; i < operations.length; i++) {
            index = map.get(operations[i][0]);
            nums[index] = operations[i][1];
            map.remove(operations[i][0]);
            map.put(operations[i][1], index);
        }
        
        return nums;
    }
}