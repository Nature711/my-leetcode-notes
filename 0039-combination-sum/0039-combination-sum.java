class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         backtrack(candidates, new ArrayList<>(), 0, target, 0);
        return res;
    }
    
    public void backtrack(int[] candidates, List<Integer> currCombi, int currSum, int target, int low) {
        
        if (currSum == target) {
            res.add(new ArrayList<>(currCombi));
            return;
        }
        
        for (int i = low; i < candidates.length; i++) {
            
            int newSum = currSum + candidates[i];
            if (newSum <= target) {
                currCombi.add(candidates[i]);
                backtrack(candidates, currCombi, newSum, target, i);
                currCombi.remove(currCombi.size() - 1);
            }
        }
    }
}