class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
    
        for (int num: nums1) map1.put(num, map1.getOrDefault(num, 0) + 1);
        for (int num: nums2) map2.put(num, map2.getOrDefault(num, 0) + 1);
        
        List<Integer> resList = new ArrayList<>();

        for (int item1: map1.keySet()) {
            int freq = Math.min(map1.get(item1), map2.getOrDefault(item1, 0));
            for (int i = 0; i < freq; i++) resList.add(item1);
        }
        
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) res[i] = resList.get(i);
        return res;
    }
}

