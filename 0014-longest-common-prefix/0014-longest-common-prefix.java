class Solution {
    String[] allStrs;
    public String longestCommonPrefix(String[] strs) {
        allStrs = strs;
        String benchmark = strs[0];
        for (String str: strs) {
            if (str.length() < benchmark.length()) benchmark = str;
        }
        int low = 0, high = benchmark.length() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isCommonPrefix(benchmark.substring(0, mid + 1))) low = mid + 1;
            else high = mid - 1;
        }
        return benchmark.substring(0, low);
    }
    
    public boolean isCommonPrefix(String prefix) {
        for (String str: allStrs) {
     
            if (!str.substring(0, prefix.length()).equals(prefix)) return false;
        }
        return true;
    }
    
   
}