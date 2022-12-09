## Wrong approach

- only works for ***non-nested bracket*** (i.e., only one level), e.g., 3[ab]2[c]
- doesn't work for ***nested bracket***, e.g., 3[ab2[c]]
```
public String decodeString(String s) {
      StringBuilder res = new StringBuilder();
      int i = 0;
      while (i < s.length()) {
          char c = s.charAt(i);
          if (Character.isDigit(c)) {
              int k = Character.getNumericValue(c);
              i = i + 2;
              StringBuilder sb = new StringBuilder();
              while (s.charAt(i) != ']') sb.append(s.charAt(i++));
              res.append(decodeHelper(sb.toString(), k));
          } else {
              if (c != '[' && c != ']') res.append(c);
              i++;
          }
      }
      return res.toString();
  }


  public String decodeHelper(String s, int k) {
      String base = s;
      for (int i = 0; i < k - 1; i++) s += base;
      return s;
  }
 
 ## Using stack
 - process from inner to outwards / 
