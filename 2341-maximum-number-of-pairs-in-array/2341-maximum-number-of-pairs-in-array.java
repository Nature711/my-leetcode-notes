class Solution {
    public int[] numberOfPairs(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        int pairs = 0;
        int leftover = 0;
        
        for (int num: map.keySet()) {
            int freq = map.get(num);
            pairs += freq / 2;
            leftover += freq % 2;
        }
        
        return new int[]{pairs, leftover};
    }
}