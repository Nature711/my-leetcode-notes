class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        while (i < strs[0].length()) {
            int benchmark = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != benchmark) return strs[0].substring(0, i);
            }
            i++;
        }
        return strs[0];
    }
}