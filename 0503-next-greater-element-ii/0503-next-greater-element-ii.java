class Solution {
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
}