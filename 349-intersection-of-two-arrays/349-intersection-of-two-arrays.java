class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num: nums1) set1.add(num);
        for (int num: nums2) set2.add(num);
        
        List<Integer> resList = new ArrayList<>();
        
        set1.forEach(item1 -> {
            if (set2.contains(item1)) resList.add(item1);
        });
        
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) res[i] = resList.get(i);
        return res;
    }
}