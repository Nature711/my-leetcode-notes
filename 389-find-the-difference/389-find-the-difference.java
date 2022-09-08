class Solution {
    public char findTheDifference(String s, String t) {
        
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        tMap.put(t.charAt(t.length() - 1), tMap.getOrDefault(t.charAt(t.length() - 1), 0) + 1);
        
        
        for (Character c: tMap.keySet()) {
            if (!sMap.containsKey(c) 
                || sMap.get(c) != tMap.get(c)) return c;
        }
        
        return 'a';
    }
}