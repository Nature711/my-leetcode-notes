class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder output = new StringBuilder();
        int i = 0, j = 0;
        while (i < s.length() && j < spaces.length) {
            if (i < spaces[j]) {
                output.append(s.charAt(i));
                i++;
            } else {
                output.append(' ');
                j++;
            }
        }
        
        while (i < s.length()) {
            output.append(s.charAt(i));
            i++;
        }
        
        return output.toString();
    }
}