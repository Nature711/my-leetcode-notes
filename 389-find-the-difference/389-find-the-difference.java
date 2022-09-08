class Solution {
    public char findTheDifference(String s, String t) {
        
        HashMap<Character, Integer> sMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        
        for (char c: t.toCharArray()) {
            
            if (sMap.containsKey(c)) {
                if (sMap.get(c) == 1) sMap.remove(c);
                else sMap.put(c, sMap.get(c) - 1);
            } else return c;
        
        }
        
        return 'a';
    }
}