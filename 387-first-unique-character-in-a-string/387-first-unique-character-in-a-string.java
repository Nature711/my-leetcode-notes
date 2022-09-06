class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> repeated = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (repeated.contains(s.charAt(i))) continue;
            if (map.containsKey(s.charAt(i))) {
                repeated.add(s.charAt(i));
                map.remove(s.charAt(i));
            } else map.put(s.charAt(i), i);
        }
        
        int first = Integer.MAX_VALUE;
        for (Character c: map.keySet()) {
            first = Math.min(first, map.get(c));
        }
        
        return first == Integer.MAX_VALUE ? -1 : first;
    }
}