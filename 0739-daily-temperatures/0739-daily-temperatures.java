class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int n = temperatures.length, i = 0;
        int[] res = new int[n];
        
        while (i < n) {
            while (!stack.isEmpty() && stack.peek().getKey() < temperatures[i]) {
                Pair<Integer, Integer> p = stack.pop();
                res[p.getValue()] = i - p.getValue();
            }
            stack.push(new Pair<>(temperatures[i], i));
            i++;
        }
        
        return res;
    }
}