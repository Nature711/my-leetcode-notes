class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> note = new HashMap<>();
        HashMap<Character, Integer> mag = new HashMap<>();
        for (char c: ransomNote.toCharArray()) note.put(c, note.getOrDefault(c, 0) + 1);
        for (char c: magazine.toCharArray()) mag.put(c, mag.getOrDefault(c, 0) + 1);

        for (char n: note.keySet()) {
            if (!mag.containsKey(n) || note.get(n) > mag.get(n)) return false;
        }
        return true;
    }
}