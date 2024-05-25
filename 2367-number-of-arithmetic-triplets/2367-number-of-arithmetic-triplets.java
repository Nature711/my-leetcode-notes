class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num + diff, map.get(num) + 1);
                map.remove(num);
            } else {
                map.put(num + diff, 1);
            }
        }
        int res = 0;
       
        for (int key: map.keySet()) {
            res += Math.max(0, map.get(key) - 3 + 1);
        }
        return res;
    }
}