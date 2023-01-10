class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] sorted = new String[strs.length];
    
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            sorted[i] = new String(chars);
        }
        
        HashMap<String, List<String>> buckets = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            if (buckets.containsKey(sorted[i])) buckets.get(sorted[i]).add(strs[i]);
            else {
                List<String> bucket = new ArrayList<>();
                bucket.add(strs[i]);
                buckets.put(sorted[i], bucket);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for (String key: buckets.keySet()) res.add(buckets.get(key));
        return res;
    }
}