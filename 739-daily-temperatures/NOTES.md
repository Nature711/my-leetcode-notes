## Brute force
- Time: O(n^2)
```
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            int currTemp = temperatures[i];
            int k = 1;
            while (i + k < n && currTemp >= temperatures[i + k]) k++;
            res[i] = (i + k == n) ? 0 : k;
        }
        
        return res;
    }
 ```
 
 ## Optimized
 - Stack keeps track of the idx of the elements whose next greater element hasn't been found 
 - Top of stack is the smallest; down the stack number is non-decresing, because we add an idx to stack only we haven't found 
 an element that is greater than the element at this idx (meaning that this idx is so large that we haven't found yet)

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
 
