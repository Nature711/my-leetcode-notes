## Intuition

- enter a letter -- push to stack
- press backspace -- pop from stack
- need to support consecutive backspace --> popping while stack not empty; letter being popped is the most recently added one

```
 public boolean backspaceCompare(String s, String t) {

      Stack<Character> stack1 = new Stack<>();
      Stack<Character> stack2 = new Stack<>();
      for (char c: s.toCharArray()) {
          if (c == '#') {
              if (!stack1.isEmpty()) stack1.pop();
          } else stack1.push(c);
      }
      for (char c: t.toCharArray()) {
          if (c == '#') {
              if (!stack2.isEmpty()) stack2.pop();
          } else stack2.push(c);
      }
      while (!stack1.isEmpty() && !stack2.isEmpty()) {
          if (stack1.pop() != stack2.pop()) return false;
      }

      return stack1.isEmpty() && stack2.isEmpty();
  }
```
