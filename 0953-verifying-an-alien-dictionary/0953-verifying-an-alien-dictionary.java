class Solution {
    HashMap<Character, Integer> map = new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) map.put(order.charAt(i), i);
        
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSmaller(words[i], words[i + 1])) return false;
        }
        
        return true;
    }
    
    public boolean isSmaller(String word1, String word2) {
        int end = Math.min(word1.length(), word2.length());
        for (int i = 0; i < end; i++) {
            int o1 = map.get(word1.charAt(i));
            int o2 = map.get(word2.charAt(i));
            if (o1 < o2) return true;
            if (o1 > o2) return false;
        }
        if (word1.length() > word2.length()) return false;
        return true;
    }
}