class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid: asteroids) {
            boolean newCollide = false;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int diff = Math.abs(stack.peek()) - Math.abs(asteroid);
                if (diff >= 0) { //current top is heavier
                    newCollide = true;
                    if (diff == 0) stack.pop();
                    break;
                } else { //incoming asteriod is heavier
                    stack.pop();
                }
            }
            
            if (!newCollide) stack.push(asteroid);
                
        }
        
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) res[i] = stack.pop();
        return res;
    }
}