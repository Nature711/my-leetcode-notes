class Solution {
    public boolean detectCapitalUse(String word) {
        
        String allUpper = word.toUpperCase();
        String firstUpper = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
        String allLower = word.toLowerCase();
        return word.equals(allUpper) || word.equals(firstUpper) || word.equals(allLower);
    }
}