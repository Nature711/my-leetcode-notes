class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int len = 0;
        Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> entry = it.next();
            int occ = entry.getValue();
            if (occ % 2 == 0) {
                len += occ;
                it.remove();
            } else {
                if (occ > 1) {
                    len += occ - 1;
                    entry.setValue(1);
                }
            }
        }
        //System.out.println(map);
        if (map.size() > 0) len++;
        return len;
    }
}