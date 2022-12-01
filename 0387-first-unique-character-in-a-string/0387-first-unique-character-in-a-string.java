class Solution {
    public int firstUniqChar(String s) {
        Set<Character> encountered = new HashSet<>();
        HashMap<Character, Integer> uniqueChars = new HashMap<>();
        char[] sArray = s.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            if (encountered.contains(sArray[i])) uniqueChars.remove(sArray[i]);
            else {
                encountered.add(sArray[i]);
                uniqueChars.put(sArray[i], i); 
            }
        }
        if (uniqueChars.isEmpty()) return -1;
        int min = Integer.MAX_VALUE;
        for (char c: uniqueChars.keySet()) min = Math.min(uniqueChars.get(c), min);
        return min;
    }
}