class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0, n = s.length(), numStrings = 1;
        while (i < n) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                i++;
            } else {
                set.clear();
                numStrings++;
            }
        }
        return numStrings;
    }
}