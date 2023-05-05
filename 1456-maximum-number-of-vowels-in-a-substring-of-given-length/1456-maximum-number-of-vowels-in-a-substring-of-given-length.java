class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int currWindow = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) currWindow++;
        }
        int max = currWindow;
        for (int i = 1; i <= s.length() - k; i++) {
            if (vowels.contains(s.charAt(i - 1))) {
                currWindow--;
            }
            if (vowels.contains(s.charAt(i + k - 1))) {
                currWindow++;
            }
            //System.out.println(s.substring(i, i + k) + " has " + currWindow + " vowels");
            max = Math.max(max, currWindow);
        }
        
        return max;
    }
}