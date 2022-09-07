class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (isPrefix(searchWord, words[i])) return i + 1;
        }
        
        return -1;
    }
    
    public boolean isPrefix(String searchWord, String word) {
        if (word.length() < searchWord.length()) return false;
        if (searchWord.length() == word.length()) return searchWord.equals(word);
        
        for (int i = 0; i < searchWord.length(); i++) {
            if (searchWord.charAt(i) != word.charAt(i)) return false;
        }
        
        return true;
    }
}