class Solution {
    public String reverseVowels(String s) {
        int low = 0;
        int high = s.length() - 1;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        char[] res = s.toCharArray();
        while (low < high) {
            while (low < high && !vowels.contains(s.charAt(high))) high--;
            while (low < high && !vowels.contains(s.charAt(low))) low++;
            res[low] = s.charAt(high);
            res[high] = s.charAt(low);
            low++;
            high--;
        }
        
        return String.valueOf(res);
    }
}