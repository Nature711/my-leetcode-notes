class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        
        int i = 0, res = 0;
        while (i < s.length()) {
            if (i + 1 < s.length()) {
                if (
                    (s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) || 
                    (s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) ||
                    (s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M'))
                ) {
                    res += map.get(s.substring(i, i + 2));
                    i = i + 2;
                } else {
                    res += map.get(s.substring(i, i + 1));
                    i++;
                }
            } else {
                res += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        
        return res;
    }
}