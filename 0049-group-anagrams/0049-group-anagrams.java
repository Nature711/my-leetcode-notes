class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            List<Integer> list = map.getOrDefault(str, new ArrayList<>());
            list.add(i);
            map.put(str, list);
        }
        List<List<String>> result = new ArrayList<>();
        for (String str: map.keySet()) {
            List<Integer> indices = map.get(str);
            List<String> res = new ArrayList<>();
            for (int idx: indices) res.add(strs[idx]);
            result.add(res);
        }
        
        return result;
    }
}