class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            int cc = (int) c;
            if ((cc >= 48 && cc <= 57) //numerical
                ||(cc >= 65 && cc <= 90) //lowercase letter
                || (cc >= 97 && cc <= 122) //uppercase letter
               ) sb.append(Character.toLowerCase((char) cc));
        }
        
        return helper(sb.toString());
    }
    
    public boolean helper(String s) {
        int n = s.length();
        if (n < 2
            || (n == 2 && s.charAt(0) == s.charAt(1))) return true;
        return s.charAt(0) == s.charAt(n - 1) && helper(s.substring(1, n - 1));
    }
}