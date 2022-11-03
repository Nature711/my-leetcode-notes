class Solution {
    public List<Integer> intersection(int[][] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums[0]) set.add(num);
        
        for (int i = 1; i < nums.length; i++) {
            HashSet<Integer> newSet = new HashSet<>();
            for (int j = 0; j < nums[i].length; j++) {
                if (set.contains(nums[i][j])) newSet.add(nums[i][j]);
            }
            set = newSet;
        }
        
        List<Integer> res = new ArrayList<>();
        for (int num: set) res.add(num);
        Collections.sort(res);
        
        return res;
    }
}