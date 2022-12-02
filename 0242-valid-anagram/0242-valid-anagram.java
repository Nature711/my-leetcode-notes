class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        if (n != t.length()) return false;
        
        int[] map = new int[26];
        
        for (char c: s.toCharArray()) map[c - 'a']++;
        
        for (char c: t.toCharArray()) map[c - 'a']--;
        
        for (int occurence: map) if (occurence != 0) return false;
        
        return true;
    }
}