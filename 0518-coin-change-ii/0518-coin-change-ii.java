class Solution {
    HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        return helper(amount, 0, coins);
    }
    
    public int helper(int amount, int idx, int[] coins) {
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        Pair<Integer, Integer> p = new Pair<>(amount, idx);
        if (map.containsKey(p)) return map.get(p);
        
        int res = 0;
        for (int i = idx; i < coins.length; i++) {
            res += helper(amount - coins[i], i, coins);
        }
        map.put(p, res);
        return res;
    }
}