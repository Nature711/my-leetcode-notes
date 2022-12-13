## Horizontal scanning (pipelining)
![image](https://user-images.githubusercontent.com/77217430/207363497-7cddd6a4-d65d-4560-a4e1-3a1aef868284.png)
```
   public String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String curr = strs[i].substring(0, Math.min(common.length(), strs[i].length()));
            int j = 0;
            while (j < curr.length()) {
                if (curr.charAt(j) != common.charAt(j)) break;
                j++;
            }
            common = curr.substring(0, j);
            if (common.length() == 0) break;
        }
        return common;
    }
```

## Vertical scanning
```
public String longestCommonPrefix(String[] strs) {
        int i = 0;
        while (i < strs[0].length()) {
            int benchmark = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != benchmark) return strs[0].substring(0, i);
            }
            i++;
        }
        return strs[0];
    }
```

## Divide & Conquer
```
```
