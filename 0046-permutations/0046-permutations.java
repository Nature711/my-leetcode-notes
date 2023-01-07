class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>(), new HashSet<>());
        return res;
    }
    
    
    public void backtrack(int[] nums, List<Integer> currPerm, HashSet<Integer> used) {
        if (currPerm.size() == nums.length) {
            res.add(new ArrayList<>(currPerm));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used.contains(i)) continue;
            currPerm.add(nums[i]);
            used.add(i);
            backtrack(nums, currPerm, used);
            currPerm.remove(currPerm.size() - 1);
            used.remove(i);
        }
    }
}