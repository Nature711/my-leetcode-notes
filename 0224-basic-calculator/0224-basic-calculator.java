class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        s = s.replaceAll("\\s+", "");
        int i = 0, j = 0;
        
        while (i < s.length()) {
                
            if (s.charAt(i) == ')') {
                
                List<String> expression = new ArrayList<>();
                while (!stack.peek().equals("(")) expression.add(stack.pop()); 
                stack.pop();
                Integer partialRes = eval(expression);
                stack.push(partialRes.toString());
                i++;
            } else {
                if (Character.isDigit(s.charAt(i))) {
                    j = i;
                    while (j < s.length() && Character.isDigit(s.charAt(j))) j++;
                    stack.push(s.substring(i, j));
                    i = j;
                } else {
                    stack.push(s.substring(i, i + 1));
                    i++;
                }
            }

            //System.out.println("currStack " + stack);
        }
        
        List<String> exp = new ArrayList<>();
        while (!stack.isEmpty()) exp.add(stack.pop());
        return eval(exp);
    }
    
    public int eval(List<String> expression) {
        
        
        String last = expression.get(expression.size() - 1);
        if (last.equals("-")) expression.add("0");
        //System.out.println("calculate" + expression);
        int n = expression.size();

        int res = Integer.parseInt(expression.get(n - 1));
        int numP = n - 3, opP = n - 2;
        while (numP >= 0 && opP >= 0) {
            String op = expression.get(opP);
            int num = Integer.parseInt(expression.get(numP));
            if (op.equals("+")) res += num;
            else res -= num;
            numP -= 2;
            opP -= 2;
        }
        //System.out.println("calculate " + expression + " gets " + res);
        return res;
    }
}