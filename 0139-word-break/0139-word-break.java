class Solution {
    HashSet<String> dictionary = new HashSet<>();
    HashMap<String, Boolean> memo = new HashMap<>();
    
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String word: wordDict) dictionary.add(word);
        return canPartition(s);
    }
    
    public boolean canPartition(String s) {
        int n = s.length();
        if (n == 0 || dictionary.contains(s)) return true;
        
        if (memo.containsKey(s)) return memo.get(s);
      
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if (dictionary.contains(s.substring(0, i))
                && canPartition(s.substring(i, n))) {
                flag = true;
                break;
            }
        }
        memo.put(s, flag);
        return flag;
    }
}