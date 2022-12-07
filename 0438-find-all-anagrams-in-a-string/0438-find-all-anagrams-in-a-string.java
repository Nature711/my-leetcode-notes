class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length(), n = p.length();
        for (int i = 0; i <= m - n; i++) {
            if (isAnagram(s.substring(i, i + n), p)) res.add(i);
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