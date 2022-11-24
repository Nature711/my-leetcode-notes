class Solution {
    public String longestCommonPrefix(String[] strs) {
        int max = 0;
        String benchmark = strs[0];
        for (int i = 0; i < benchmark.length(); i++) {  
            for (String str: strs) {
                if (i == str.length() || str.charAt(i) != benchmark.charAt(i)) return benchmark.substring(0, max);
            }
            max++;
        }
        return benchmark.substring(0, max);
    }
}