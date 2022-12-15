class Solution {
    String[] allStrs;
    public String longestCommonPrefix(String[] strs) {
        allStrs = strs;
        return longestHelper(0, strs.length - 1);
    }
    
    public String longestHelper(int low, int high) {
        if (low == high) return allStrs[low];
        int mid = low + (high - low) / 2;
        String s1 = longestHelper(low, mid);
        String s2 = longestHelper(mid + 1, high);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)) break;
            sb.append(s1.charAt(i));
        }
        return sb.toString();
    }
    
}