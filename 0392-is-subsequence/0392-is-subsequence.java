class Solution {
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
}