class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String curr = strs[i].substring(0, Math.min(common.length(), strs[i].length()));
            int j = 0;
            while (j < curr.length()) {
                if (curr.charAt(j) != common.charAt(j)) break;
                j++;
            }
            common = curr.substring(0, j);
            if (common.length() == 0) break;
        }
        return common;
    }
}