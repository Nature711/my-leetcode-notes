class Solution {
    public boolean validPalindrome(String s) {
        return isValid(s, 0, s.length() - 1, false);
    }
    
    boolean isValid(String s, int low, int high, boolean hasSkipped) {
        if (high - low < 1) return true;
        if (s.charAt(low) == s.charAt(high)) {
            return isValid(s, low + 1, high - 1, hasSkipped);
        } else if (!hasSkipped) {
            return isValid(s, low, high - 1, true) || isValid(s, low + 1, high, true);
        } else {
            return false;
        }
    }
}