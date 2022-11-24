class Solution {
    public String longestCommonPrefix(String[] strs) {
        int max = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            max = Math.min(strs[i].length(), max);
            for (int j = 0; j < max; j++) {
                if (strs[i].charAt(j) != strs[0].charAt(j)) {
                    max = j;
                    break;
                }
            }
            if (max == 0) break;
        }
        return strs[0].substring(0, max);
    }
}