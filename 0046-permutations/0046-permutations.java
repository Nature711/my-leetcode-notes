class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return res;
    }
    
    
    public void backtrack(int[] nums, List<Integer> currPerm) {
        if (currPerm.size() == nums.length) {
            res.add(new ArrayList<>(currPerm));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (currPerm.contains(nums[i])) continue;
            currPerm.add(nums[i]);
            backtrack(nums, currPerm);
            currPerm.remove(currPerm.size() - 1);
        }
    }
}