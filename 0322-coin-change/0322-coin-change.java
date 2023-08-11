class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        
        if (memo.containsKey(amount)) return memo.get(amount);
        
        int res = amount + 1;
        for (int coin: coins) {
            int sub = coinChange(coins, amount - coin);
            if (sub == -1) continue;
            res = Math.min(res, sub + 1);
        }
        res = res > amount ? -1 : res;
        memo.put(amount, res);
        
        return res;
    }
    

}