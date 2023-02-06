class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        HashSet<Integer> universe = new HashSet<>();
        for (int i = 1; i <= n; i++) universe.add(i);
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num: nums) {
            if (universe.contains(num)) universe.remove(num);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int rem: universe) res.add(rem);
        return res;
        
    }
}