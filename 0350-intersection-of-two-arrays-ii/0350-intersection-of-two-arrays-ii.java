class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        
        int[] shorter = m < n ? nums1 : nums2;
        int[] longer = m < n ? nums2 : nums1;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: shorter) map.put(num, map.getOrDefault(num, 0) + 1);
        
        List<Integer> res = new ArrayList<>();
        for (int num: longer) {
            if (map.containsKey(num)) {
                res.add(num);
                if (map.get(num) == 1) map.remove(num);
                else map.put(num, map.get(num) - 1);
            } 
        }
        
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) arr[i] = res.get(i);
        return arr;
    }
        
}