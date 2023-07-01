class Solution {
    int minUnfairness = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] state = new int[k];
        backtrack(0, state, cookies);
        return minUnfairness;
    }
    
    public void backtrack(int cookieIdx, int[] state, int[] cookies) {
        if (cookieIdx == cookies.length) {
            int max = 0;
            for (int s: state) max = Math.max(max, s);
            minUnfairness = Math.min(minUnfairness, max);
            return;
        }
        
        for (int i = 0; i < state.length; i++) {
            state[i] += cookies[cookieIdx];
            backtrack(cookieIdx + 1, state, cookies);
            state[i] -= cookies[cookieIdx];
        }
    }
}