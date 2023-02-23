class Solution {
    
    public String decodeString(String s) {
        Stack<Object> stack = new Stack<>();
        
        StringBuilder res = new StringBuilder();
        int i = 0, n = s.length();
        while (i < n) {
            if (Character.isDigit(s.charAt(i))) {
                StringBuilder num = new StringBuilder();
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num.append(s.charAt(i));
                    i++;
                }
                if (i == n || s.charAt(i) != '[') return "";
                i--;
                stack.push(Integer.valueOf(num.toString()));
            } else if (s.charAt(i) == ']') {
                StringBuilder pattern = new StringBuilder();
                while (true) {
                    char c = (Character) stack.peek();
                    if (c == '[') break;
                    pattern.append((Character)stack.pop());
                }
                stack.pop(); //pop '['
                pattern = pattern.reverse();
                int times = (Integer) stack.pop();
                for (int t = 0; t < times; t++) {
                    for (int j = 0; j < pattern.length(); j++) stack.push(pattern.charAt(j));
                }
            } else {
                stack.push(s.charAt(i));
            }
            i++;
        }
        while (!stack.isEmpty()) { 
            res.append((Character) stack.pop());
        }
        return res.reverse().toString();
    }
}