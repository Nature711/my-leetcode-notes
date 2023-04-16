class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            //System.out.println(" before i " + i + " " + stack + " j " + j);
            if (!stack.isEmpty() && stack.peek() == popped[j]) {
                //System.out.println("case1");
                stack.pop();
                j++;
                i--;
            } else {
                //System.out.println("case2");
                stack.push(pushed[i]);
                if (stack.peek() == popped[j]) {
                    //System.out.println("case2.1");
                    stack.pop();
                    j++;
                } else { }//System.out.println("case2.2");
                
            }       
            //System.out.println("after i " + i + " " + stack + " j " + j);
        }
        
        while (!stack.isEmpty()) {
            if (stack.pop() != popped[j++]) return false;
        }
        return true;
    }

}