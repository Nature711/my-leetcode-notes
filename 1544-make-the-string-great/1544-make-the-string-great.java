class Solution {
    public String makeGood(String s) {
        
        if (s.length() < 2) return s;
        
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for (char c: chars) {
            if (stack.isEmpty()) stack.push(c);
            else {
                char top = stack.peek();
                if (Math.abs(top - c) == 32) stack.pop();
                else stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}