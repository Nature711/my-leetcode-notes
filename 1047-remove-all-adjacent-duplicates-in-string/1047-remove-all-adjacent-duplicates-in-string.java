class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        
        for (char c: chars) {
            if (stack.isEmpty()) stack.push(c);
            else {
                if (c == stack.peek()) stack.pop();
                else stack.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}