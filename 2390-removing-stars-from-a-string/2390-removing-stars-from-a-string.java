class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') count++; //one more *
            else {
                //normal char
                if (count == 0) stack.push(s.charAt(i)); //keep
                else count--; //use a char to offset * 
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) res.append(stack.pop());
        return res.toString();
    }
}