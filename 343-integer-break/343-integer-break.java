class Solution {
    
    HashMap<Integer, Integer> memo = new HashMap<>();
    
    public int integerBreak(int n) {
        if (n <= 2) return 1;
        
        int res = 1;
        for (int curr = n - 1; curr > 0; curr--) {
            if (!memo.containsKey(n - curr)) {
                memo.put(n - curr, integerBreak(n - curr));
            }
            res = Math.max(res, Math.max(curr * memo.get(n - curr), curr * (n - curr)));
        }
        return res;
    }
}