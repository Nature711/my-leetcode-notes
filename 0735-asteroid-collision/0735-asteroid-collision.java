class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stones = new Stack<>();
        int n = asteroids.length;
        for (int i = 0; i < n; i++) {
            int stoneToPush = asteroids[i];
            boolean bothExploded = false;
            if (!stones.isEmpty() && stones.peek() > 0 && stoneToPush < 0) {
                while (!stones.isEmpty() && stones.peek() > 0 && stoneToPush < 0) {
                    int top = stones.pop();
                    int diff = Math.abs(top) - Math.abs(stoneToPush);
                    if (diff > 0) { //top is heavier
                        stoneToPush = top;
                    } else if (diff < 0) { //stone to push is heavier 
                        stoneToPush = stoneToPush;
                    } else {
                        //both stones explore, do nothing
                        bothExploded = true;
                        break;
                    }
                }
            }
            
            if (!bothExploded) stones.push(stoneToPush);
        }
        
        int[] res = new int[stones.size()];
        int i = stones.size() - 1;
        while (!stones.isEmpty()) res[i--] = stones.pop();
        return res;
    }
}