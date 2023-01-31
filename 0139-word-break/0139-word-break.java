class Solution {
    HashSet<String> dictionary = new HashSet<>();
 
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String word: wordDict) dictionary.add(word);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        //dp[i] = whether the substring s(0...i) inclusive can be partitioned
        dp[0] = true;
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dictionary.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            } 
        }
        
        return dp[n];
    }
    

}