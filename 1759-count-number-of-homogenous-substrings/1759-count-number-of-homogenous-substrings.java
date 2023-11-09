class Solution {
    public int countHomogenous(String s) {
        int i = 0, n = s.length();
        long res = 0;
        int MOD = (int) 1e9 + 7;
        while (i < n) {
            long currStrike = 1;
            while (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                currStrike++;
                i++;
            }
            res += ((1 + currStrike) * currStrike / 2) % MOD;
            i++;
        }
        return (int) res;
    }

}