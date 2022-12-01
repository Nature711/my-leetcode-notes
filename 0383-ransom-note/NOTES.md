## Two hashmaps
```
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
 ```
 
 ## Sort string
```
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] note = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        Arrays.sort(note);
        Arrays.sort(mag);
        
        int i = 0, j = 0;
        while (i < note.length) {
            if (j == mag.length) return false;
            if (note[i] == mag[j]) {
                i++;
                j++; 
            } else j++;
        }
        return true;
    }
```

## Constant size array
- similar to hashmap but make use of array slot to store occurences of the char that is represented by (char) i
- condense 2 hashmaps into 1 -- first one iterating through magazine to increment the occurence; second one then iterating through note to decrement occurences
```
public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char c: magazine.toCharArray()) map[c - 'a']++;
        for (char c: ransomNote.toCharArray()) {
            if (map[c - 'a']-- == 0) return false;
        }
        return true;
}
```
