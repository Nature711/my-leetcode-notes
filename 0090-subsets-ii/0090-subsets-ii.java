class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for (int size = 0; size <= nums.length; size++) backtrack(nums, new ArrayList<>(), size, 0, new HashSet<>());
        return res;
    }
    public void backtrack(int[] nums, List<Integer> currSet, int size, int start, HashSet<Integer> indices) {
        if (currSet.size() == size) {
            res.add(new ArrayList<>(currSet));
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            currSet.add(nums[i]);
            backtrack(nums, currSet, size, i + 1, new HashSet<>());
            currSet.remove(currSet.size() - 1);
        }
    }
}