class Solution {
    public String makeGood(String s) {
        
        if (s.length() < 2) return s;
        
        char[] chars = s.toCharArray();
        Stack<Character> oldStack = new Stack<>();
        for (char c: chars) oldStack.push(c);
        
        Stack<Character> newStack = new Stack<>();
        
      
        while (!oldStack.isEmpty()) {
     
            if (newStack.isEmpty()) newStack.push(oldStack.pop());

            if (oldStack.isEmpty()) break;
            char oldTop = oldStack.peek();
            char newTop = newStack.peek();
            if (Math.abs(oldTop - newTop) == 32) {
                System.out.println(oldTop + "is a low/upper case of " + newTop);
                oldStack.pop();
                newStack.pop();
            } else newStack.push(oldStack.pop());
       
        }
        StringBuilder sb = new StringBuilder();
        while (!newStack.isEmpty()) sb.append(newStack.pop());
        return sb.toString();
    }
}