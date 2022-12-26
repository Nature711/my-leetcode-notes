class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2) return n;
        
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int start = 0, end = 1, max = 0;
        
        while (start < n && end < n) {
            if (map.containsKey(s.charAt(end))) {
                max = Math.max(max, end - start);
                int pos = map.get(s.charAt(end));
                for (int i = start; i <= pos; i++) map.remove(s.charAt(i));
                start = pos + 1;
            } else {
                map.put(s.charAt(end), end);
                end++;
                max = Math.max(max, end - start);
            }
        }
        
        return max;
    }
}