class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        for (int size = 0; size <= nums.length; size++) backtrack(nums, new HashSet<>(), size, 0);
        return res;
    }
    public void backtrack(int[] nums, HashSet<Integer> currSet, int size, int start) {
        if (currSet.size() == size) {
            List<Integer> subset = new ArrayList<>();
            for (int n: currSet) subset.add(n);
            res.add(subset);
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            currSet.add(nums[i]);
            backtrack(nums, currSet, size, i + 1);
            currSet.remove(nums[i]);
        }
    }
}