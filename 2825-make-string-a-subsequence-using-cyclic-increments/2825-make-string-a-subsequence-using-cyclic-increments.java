class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < str1.length() && ptr2 < str2.length()) {
            int diff = str1.charAt(ptr1) - str2.charAt(ptr2);
            if (diff == 0 || diff == -1 || diff == 25) {
                ptr2++;
            }
            ptr1++;
        }
        
        if (ptr2 < str2.length()) return false;
        else return true;
    }
}