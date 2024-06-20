class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int numTrees(int n) {
        if (n < 2) return 1;
        
        if (memo.containsKey(n)) return memo.get(n);

        int res = 0;
        for (int numLeft = 0; numLeft < n; numLeft++) {
                res += numTrees(numLeft) * numTrees(n - numLeft - 1);
        }

        memo.put(n, res);
        return res;    
    }
}