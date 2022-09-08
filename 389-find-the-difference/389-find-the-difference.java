class Solution {
    public char findTheDifference(String s, String t) {
        
        int[] arr = new int[26];
        for (char c: s.toCharArray()) arr[c - 'a']++;
        
        for (char c: t.toCharArray()) {
            if (arr[c - 'a'] == 0) return c;
            
            arr[c - 'a']--;
        }
        
        return 'a';
    }
}