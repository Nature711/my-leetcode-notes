class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        
        int rem = num.length() - k;
        if (rem == 0) return "0";
        for (char c: num.toCharArray()) {
            int curr = Character.getNumericValue(c);
            while (!stack.isEmpty() && curr < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(curr);
        }
        while (k-- > 0) stack.pop();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(Integer.toString(stack.pop()));
        
        String res = sb.reverse().toString();
        int i = 0;
        
        while (i < res.length() && res.charAt(i) == '0') i++;
        res = res.substring(i);
        return res.length() == 0 ? "0" : res;
    }
}