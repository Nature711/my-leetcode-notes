class Solution {
     public boolean repeatedSubstringPattern(String s) {
         
        for (int slen = 1; slen < s.length(); slen++) {
            String pattern = s.substring(0, slen);
            for (int i = slen; i < s.length(); i = i + slen) {
                if (i + slen > s.length() || !s.substring(i, i + slen).equals(pattern)) break;
                else if (i + slen == s.length()) return true;
            }
        }
         
        return false;
    }
}