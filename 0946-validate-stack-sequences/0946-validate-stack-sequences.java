class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0, n = pushed.length;
        
        while (i < n) {
            if (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
                continue;
            } 
            stack.push(pushed[i]);
            i++;
        }
        
        while (!stack.isEmpty()) {
            if (stack.pop() != popped[j++]) return false;
        }
        return true;
    }

}