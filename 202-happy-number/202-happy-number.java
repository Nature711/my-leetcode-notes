class Solution {
    
    HashSet<Integer> set = new HashSet<>();
    
    public boolean isHappy(int n) {

        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n % 10);
            n = n / 10;
        }
        int newNum = 0;
        while (!stack.isEmpty()) newNum += Math.pow(stack.pop(), 2);
        
        if (newNum == 1) return true;
        if (set.contains(newNum)) return false;
        set.add(newNum);
        
        return isHappy(newNum);
    }
}