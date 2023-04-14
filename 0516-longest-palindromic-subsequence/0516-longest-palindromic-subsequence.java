class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int T[][] = new int[n][n];
        for(int i=0; i < n; i++){
            T[i][i] = 1;
        }
        for(int l = 2; l <= n; l++){
            for(int i = 0; i < n - l + 1; i++){
                int j = i + l - 1;
                if(l == 2 && s.charAt(i) == s.charAt(j)){
                    T[i][j] = 2;
                }else if(s.charAt(i) == s.charAt(j)){
                    T[i][j] = T[i + 1][j-1] + 2;
                }else{
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }
        return T[0][n-1];
    }
}