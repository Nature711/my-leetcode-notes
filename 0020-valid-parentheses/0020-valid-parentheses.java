class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (!stack.isEmpty() && isMatching(c, stack.peek())) stack.pop();
            else stack.push(c);
        }

        return stack.isEmpty();
    }
    
    public boolean isMatching(char input, char stackTop) {

        if (input == ')') return stackTop == '(';
        if (input == ']') return stackTop == '[';
        if (input == '}') return stackTop == '{';
        return false;
    }
}