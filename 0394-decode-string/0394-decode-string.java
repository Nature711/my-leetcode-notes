class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') sb.append(stack.pop());
                stack.pop(); //pop [
                StringBuilder k = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) k.append(stack.pop());
                int times = Integer.valueOf(k.reverse().toString());
                String temp = repeatK(sb.reverse().toString(), times);
                for (char ch: temp.toCharArray()) stack.push(ch);
            } else stack.push(c);
        }
        
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) res.append(stack.pop());
        return res.reverse().toString();
    
    }
   
    public String repeatK(String s, int k) {
        String base = s;
        for (int i = 0; i < k - 1; i++) s += base;
        return s;
    }
}