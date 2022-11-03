class Solution {
    public List<Integer> intersection(int[][] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                map.put(nums[i][j], map.getOrDefault(nums[i][j], 0) + 1);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (int num: map.keySet()) {
            if (map.get(num) == nums.length) res.add(num);
        }
        Collections.sort(res);
        return res;
    }
}