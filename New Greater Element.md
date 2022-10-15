## [Next Greater Element](https://leetcode.com/problems/next-greater-element-ii/)
```
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length; 
        int nn = n * 2 - 1;
        int[] numsum = new int[nn];
        for (int i = 0; i < nn; i++) numsum[i] = nums[i % n];
        
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[i] = -1;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < nn; i++) {
            while (!stack.isEmpty() && numsum[stack.peek()] < numsum[i]) {
                int x = stack.pop();
                res[x % n] = numsum[i];
            }
            stack.push(i);
        }
        return res;
    }
```

## [Daily temperatures](https://leetcode.com/problems/daily-temperatures/)
```
 public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) res[stack.pop()] = 0;
        
        return res;
    }
```
