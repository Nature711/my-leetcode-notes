class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (!s.equals(goal)) {
            char s1 = '1', s2 = '2';
            int diffCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (diffCount > 2) return false;
                    if (diffCount == 0) {
                        s1 = s.charAt(i);
                        s2 = goal.charAt(i);
                        diffCount++;
                    } else {
                        if (s.charAt(i) != s2 || goal.charAt(i) != s1) return false;
                        diffCount++;
                    }
                }
            }
            if (diffCount != 2) return false;
        } else {
            HashSet<Character> set = new HashSet<>();
            for (char c: s.toCharArray()) {
                set.add(c);
            }
            if (set.size() < s.length()) return true;
            else return false;
        }
        return true;
    }
}