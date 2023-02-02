class Solution {
    List<String> res = new ArrayList<>();
    String allDigits;
    HashMap<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        allDigits = digits;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(0, new StringBuilder());
        return res;
    }
    
    public void backtrack(int idx, StringBuilder curr) {
        if (idx == allDigits.length()) {
            res.add(curr.toString());
            return;
        }
        String possibilities = map.get(allDigits.charAt(idx));
        for (char possibility: possibilities.toCharArray()) {
            curr.append(possibility);
            backtrack(idx + 1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}