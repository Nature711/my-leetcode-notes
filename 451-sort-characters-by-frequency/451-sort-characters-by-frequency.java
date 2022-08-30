class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        
        HashMap<Integer, List<Character>> buckets = new HashMap<>();
        
        for (char c: map.keySet()) {
            int freq = map.get(c);
            if (buckets.containsKey(freq)) {
                buckets.get(freq).add(c);
            } else {
                List<Character> list = new ArrayList<>();
                list.add(c);
                buckets.put(freq, list);
            }
        }
     
        String res = "";
        
        for (int freq = s.length(); freq > 0; freq--) {
            if (buckets.containsKey(freq)) {
                List<Character> list = buckets.get(freq);
                for (int i = 0; i < list.size(); i++) {
                    if (res.length() == s.length()) return res;
                    int f = freq;
                    char c = list.get(i);
                    while (f > 0) {
                        res += c;
                        f--;
                    }
                }
            }
            if (res.length() == s.length()) return res;
        }
     
        return res;
        
    }
}