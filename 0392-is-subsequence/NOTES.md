## Stack

- Goal: to detect if s is a subsequence of t
- s being a subsequence of t: s can be obtained by removing some characters of t, while maintaining relative order
--> think of a stack
  - removing <--> popping from stack
  - relative order maintained naturally
```
   public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true; 
        Stack<Character> stack = new Stack<>();
        for (char c: t.toCharArray()) stack.push(c);
        
        int ptr = s.length() - 1;
        while (!stack.isEmpty()) {
            if (stack.pop() == s.charAt(ptr)) ptr--;
            if (ptr < 0) return true;
        }
        
        return false;
    }
```

## Two pointers

```
public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        
        int sptr = 0, tptr = 0;
        
        while (sptr < s.length() && tptr < t.length()) {
            //keep advancing tptr until we find a match with sptr, or tptr is out of bounds
            while (tptr < t.length() && s.charAt(sptr) != t.charAt(tptr)) tptr++;
            /**when exiting from the while loop above, it means:
            //either we find a match in s, in which case we want to advance sptr, or
            //tptr is out of bounds, in which case we want to break from this 
            **/
            tptr++;
            if (tptr > t.length()) return false;
            sptr++;
        }
        
        return sptr == s.length();
    }
```
