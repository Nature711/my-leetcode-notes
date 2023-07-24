class Solution {
    
    public int eval(List<String> exp) {
       // System.out.println("exp " + exp);
        if (exp.size() == 1) return Integer.parseInt(exp.get(0));
        int res, start;
        if (exp.get(0).equals("-")) {
            res = -Integer.parseInt(exp.get(1));
            start = 2;
        } else {
            res = Integer.parseInt(exp.get(0));
            start = 1;
        }
        
        
        for (int i = start; i < exp.size(); i = i + 2) {
            if (exp.get(i).equals("+")) res += Integer.parseInt(exp.get(i + 1));
            else res -= Integer.parseInt(exp.get(i + 1));
        }
        return res;
    }
    
    
    
    public int calculate(String s) {
        
        s = s.replaceAll("\\s", "");
        int n = s.length(), i = n - 1;
        Stack<String> stack = new Stack<>();
        int res = 0;
    
        while (i >= 0) {
            if (s.charAt(i) == '(') {
                List<String> list = new ArrayList<>();
                while (!stack.peek().equals(")")) {
                    list.add(stack.pop());
                }
                stack.pop(); //pop )
                int tmp = eval(list);
                stack.push(String.valueOf(tmp));
            } else if (Character.isDigit(s.charAt(i))) {
                int pow = 0, num = 0;
                while (i >= 0 && Character.isDigit(s.charAt(i))) {
                    num += Character.getNumericValue(s.charAt(i)) * Math.pow(10, pow);
                    i--;
                    pow++;
                }
                i++;
                stack.push(String.valueOf(num));
            } else {
                stack.push(s.substring(i, i+1));
            }
            i--;  
            //System.out.println("stack " + stack);
        }
        
        if (!stack.isEmpty()) {
            List<String> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            res += eval(list);
        }
        
        return res;
    }
    
}