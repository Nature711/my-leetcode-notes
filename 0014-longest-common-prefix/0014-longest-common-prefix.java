class Solution {
    String[] allStrs;
    public String longestCommonPrefix(String[] strs) {
        allStrs = strs;
        int idx = helper(0, strs.length - 1);
        return strs[0].substring(0, idx);
    }
    
    public int helper(int low, int high) {
        if (low == high) return allStrs[low].length();
        int mid = low + (high - low) / 2;
        int leftLongest = helper(low, mid);
        int rightLongest = helper(mid + 1, high);
        int minBetween = Math.min(leftLongest, rightLongest);
        for (int i = 0; i < minBetween; i++) {
            if (allStrs[low].charAt(i) != allStrs[high].charAt(i)) return i;
        }
        return minBetween;
    }
}