class Solution {
    public String multiply(String num1, String num2) {
        
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        int n1 = num1.length();
        int n2 = num2.length();
        int padding = 0;
        Stack<String> stack = new Stack<>();
        
        for (int i = n2 - 1; i >= 0; i--) {
            
            int d2 = Character.getNumericValue(num2.charAt(i));
            int curr = 0, carry = 0;
            
            StringBuilder temp = new StringBuilder();
            for (int a = 0; a < padding; a++) temp.append(0);
            
            for (int j = n1 - 1; j >= 0; j--) {
                int d1 = Character.getNumericValue(num1.charAt(j));
                curr = d2 * d1 + carry;
                
                temp.append(curr % 10);
                carry = curr / 10;
            }
            
            if (carry > 0) temp.append(carry);
            
            stack.push(temp.reverse().toString());
            padding++;
        }
        
        String res = stack.pop();
        while (!stack.isEmpty()) {
            res = addStrings(res, stack.pop());
        }
        return res;
    }
    
    
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int value = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            res.append(value);
            p1--;
            p2--;    
        }
        
        if (carry != 0)
            res.append(carry);
        
        return res.reverse().toString();
    }
}