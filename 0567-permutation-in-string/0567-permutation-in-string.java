class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        
        for (char c: s1.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);
        
        int left = 0, right = 0, valid = 0;
        
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c).equals(need.get(c))) valid++;
            
            while (need.size() == valid) {
                if (right - left == s1.length()) return true;
                char cc = s2.charAt(left);
                left++;
                window.put(cc, window.get(cc) - 1);
                if (need.containsKey(cc) && window.get(cc) < need.get(cc)) valid--;
            }
        }
        
        return false;
    }
    
  
    
}