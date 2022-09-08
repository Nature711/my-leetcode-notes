## 2 HashMaps
```
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
```

## 1 HashMap
- in first iteration, s puts the characters it has and its frequency
- in second iteration, t looks into sMap and decrements the frequency for the character it encounters
```
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
```

## 1 fixed size array
- the i-th index of the array stores the frequency of the i-th English letter (a is the 0th, b is the 1th...)
```
    public char findTheDifference(String s, String t) {
        
        int[] arr = new int[26];
        for (char c: s.toCharArray()) arr[c - 'a']++;
        
        for (char c: t.toCharArray()) {
            if (arr[c - 'a'] == 0) return c;
            
            arr[c - 'a']--;
        }
        
        return 'a';
    }
```

## Sorting characters
```
 public char findTheDifference(String s, String t) {
        
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        
        for (int i = 0; i < tArray.length; i++) {
            if (i < s.length() && sArray[i] != tArray[i]) return tArray[i];
        }
        
        return tArray[tArray.length - 1];
    }
```

## Char to int and 'find the difference' literally
```
    public char findTheDifference(String s, String t) {
        int charCode = t.charAt(s.length());
        // Iterate through both strings and char codes
        for (int i = 0; i < s.length(); ++i) {
              charCode -= (int)s.charAt(i);
              charCode += (int)t.charAt(i); 
        }
        return (char)charCode;
    }
```
