class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num: nums) {
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }
        
        Map<Integer, List<Integer>> frequencyTable = new HashMap<>();
        
        for (int num: map.keySet()) {
            int frequency = map.get(num);
            if (frequencyTable.containsKey(frequency)) {
                frequencyTable.get(frequency).add(num);
            } else {
                List<Integer> arr = new ArrayList<>();
                arr.add(num);
                frequencyTable.put(frequency, arr);
            }
        }
        
        int[] res = new int[k];
        
        for (int freq = nums.length; freq > 0; freq--) {
            if (frequencyTable.containsKey(freq)) {
                List<Integer> list = frequencyTable.get(freq);
                for (int num: list) {
                    res[--k] = num;
                    if (k == 0) return res;
                }
            }
        }
        
        return res;
            
    }
}