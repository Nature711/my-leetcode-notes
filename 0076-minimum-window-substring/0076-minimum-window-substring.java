class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> have = new HashMap<>();
        int valid = 0;
        for (char c: t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int startIdx = -1, minLen = Integer.MAX_VALUE;
        
        while (right < s.length()) {
            // expanding window
            char rightChar = s.charAt(right);
            if (need.containsKey(rightChar)) {
                have.put(rightChar, have.getOrDefault(rightChar, 0) + 1); 
                if (have.get(rightChar).equals(need.get(rightChar))) valid++;
            }
            
            // shrinking window
            while (valid == need.size()) {
                int currLen = right - left + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    startIdx = left;
                }
                
                char leftChar = s.charAt(left);
                if (need.containsKey(leftChar)) {
                    int rem = have.get(leftChar) - 1;
                    if (rem < need.get(leftChar)) valid--;
                    
                    if (rem == 0) have.remove(leftChar);
                    else have.put(leftChar, rem);
                }
                left++;
            }
            right++;
        }
        
        if (startIdx == -1) return "";
        return s.substring(startIdx, startIdx + minLen);
    }
}