class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int curr = 0;
        Stack<Integer> stack = new Stack<>();
        
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        while (i >= 0 && j >= 0) {
            curr =
                Character.getNumericValue(num1.charAt(i)) +
                Character.getNumericValue(num2.charAt(j)) + carry;
            stack.push(curr % 10);
            carry = curr > 9 ? 1 : 0;
            i--;
            j--;
        }
        
        if (i >= 0 && j < 0) {
            while (i >= 0) {
                curr = Character.getNumericValue(num1.charAt(i)) + carry;
                stack.push(curr % 10);
                carry = curr > 9 ? 1 : 0;
                i--;
            }
        }
        
        
        if (i < 0 && j >= 0) {
            while (j >= 0) {
                curr = Character.getNumericValue(num2.charAt(j)) + carry;
                stack.push(curr % 10);
                carry = curr > 9 ? 1 : 0;
                j--;
            }
        } 
        
        if (carry > 0) stack.push(carry);
        
     
        String res = "";
        
        while (!stack.isEmpty()) {
            res += stack.pop().toString();
        }
        
        return res;
        
    }
}