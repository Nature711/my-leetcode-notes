class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length(), n = p.length();
    
        int i = 0; 
        while (i <= m - n) {
            while (i <= m - n) {
                if (isAnagram(s.substring(i, i + n), p)) {
                    res.add(i);
                    break;
                }
                i++;
            }
            //i is the starting index of the first anagram
            //first angaram window: [i, i + n)
            while (i < m - n && s.charAt(i + n) == s.charAt(i)) {
                res.add(i + 1);
                i++;
            }
            i++;
        }
        
        
        return res;
        
    }
    
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int[] map = new int[26];
        for (char c: s.toCharArray()) map[c - 'a']++;
        for (char c: t.toCharArray()) map[c - 'a']--;
        for (int occurence: map) if (occurence != 0) return false;
        return true;
    }
}