class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int valid = 0;
        for (char c: t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int startIdx = -1, minLen = Integer.MAX_VALUE;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c).equals(need.get(c))) valid++;
            
            while (valid == need.size()) {
                int currLen = right - left;
                if (currLen < minLen) {
                    minLen = currLen;
                    startIdx = left;
                }
                
                char cc = s.charAt(left);
                left++;
                window.put(cc, window.get(cc) - 1); // window.get() won't throw error
                if (need.containsKey(cc) && window.get(cc) < need.get(cc)) valid--;
            }
        }
        
        if (startIdx == -1) return "";
        return s.substring(startIdx, startIdx + minLen);
    }
}