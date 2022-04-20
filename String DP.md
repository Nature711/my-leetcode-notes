## Longest Palindromic Subsequence

### Links:
- [Question](https://leetcode.com/problems/longest-palindromic-subsequence/)
- [Explanation](https://www.youtube.com/watch?v=OZX1nqaQ_9M&t=202s)

### Solution 1: Make use of LCS
- Idea: find the LCS of the input string and its reverse

```
   public int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[1][n];
    }
```
    
  ### Solution 2: Increasing length
  - Idea: build up subproblems by considering palindromic subsequence of increasing lengths
  
  ![image](https://user-images.githubusercontent.com/77217430/164228688-b19b6cbb-30c5-4cce-8683-16e18bb21bdf.png)

```
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
```
