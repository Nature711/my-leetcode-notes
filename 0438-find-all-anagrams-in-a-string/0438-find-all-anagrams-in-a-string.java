class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length(), n = p.length();
        if (m < n) return res;
        boolean isSame = true;
        
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (char c: p.toCharArray()) pCount[c - 'a']++;
        
        for (int i = 0; i < n; i++) sCount[s.charAt(i) - 'a']++;
        
         for (char c: p.toCharArray()) {
            if (sCount[c - 'a'] != pCount[c - 'a']) {
                isSame = false;
                break;
            }
        }
        if (isSame) res.add(0);
        
        for (int i = 1; i <= m - n; i++) {
             
          sCount[s.charAt(i + n - 1) - 'a']++;
          sCount[s.charAt(i - 1) - 'a']--;
            
           isSame = true;
            for (char c: p.toCharArray()) {
                if (sCount[c - 'a'] != pCount[c - 'a']) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) res.add(i);
           
        }
        
        return res;
        
    }
    

    
}