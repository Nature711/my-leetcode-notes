class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            StringBuilder word = new StringBuilder();
            while (i < s.length() && s.charAt(i) == ' ') i++;
            while (i < s.length() && s.charAt(i) != ' ') word.append(s.charAt(i++));
            if (word.length() > 0) stack.push(word.toString());
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
            if (stack.size() > 0) res.append(" ");
        }
        return res.toString();
    }
}