class Solution {
    
    public int fib(int n) {
        if (n < 2) return n;
        int preprev = 0, prev = 1, curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = preprev + prev;
            preprev = prev;
            prev = curr;
        }
        return curr;
    }
}