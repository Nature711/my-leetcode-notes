class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;
    public List<List<Integer>> subsets(int[] nums) {
        candidates = nums;
        backtrack(0, new ArrayList<>());
        return res;
    }
    
    public void backtrack(int level, List<Integer> currSet) {
        if (level == candidates.length) {
            res.add(new ArrayList<>(currSet));
            return;
        }
        
        //don't include candiates[level]
        backtrack(level + 1, currSet);
        
        //include candiates[level]
        currSet.add(candidates[level]);
        backtrack(level + 1, currSet);
        currSet.remove(currSet.size() - 1);
    }
}