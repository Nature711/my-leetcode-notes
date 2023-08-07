class Solution {
    public int calculate(String s) {
        Queue<Character> q = new LinkedList<>();
        for (char c: s.toCharArray()) {
            if (c != ' ') q.add(c);
        }
        q.add(' ');
        return helper(q);
    }
    
    public int helper(Queue<Character> q) {
        int prev = 0, curr = 0, sum = 0;
        char prevOp =  '+';
        
        while (!q.isEmpty()) {
            char c = q.poll();
            
            if (Character.isDigit(c)) {
                int digit = c - '0';
                curr = curr * 10 + digit;
            } else if (c == '(') {
                curr += helper(q);
            } else {
                switch (prevOp) {
                    case '+':
                        sum += prev;
                        prev = curr;
                        break;
                    case '-': 
                        sum += prev;
                        prev = -curr;
                        break;
                    case '*':
                        prev *= curr;
                        break;
                    case '/':
                        prev /= curr;
                        break;
                }

                if (c == ')') break;

                curr = 0;
                prevOp = c;
            }
        }
        return sum + prev;
    }
}