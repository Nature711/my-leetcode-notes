class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> dictionary = new HashMap<>();
        HashMap<Character, Integer> rem = new HashMap<>();
        HashMap<Character, Integer> found = new HashMap<>();
        for (char c: t.toCharArray()) {
            dictionary.put(c, dictionary.getOrDefault(c, 0) + 1);
            rem.put(c, rem.getOrDefault(c, 0) + 1);
        }
        int low = 0, high = 0, n = s.length(), len = s.length(), bestL = low, bestH = high;
        String res = s.substring(bestL, bestH);
        
        while (low < n) {
            while (rem.size() > 0 && high < n) {
                char curr = s.charAt(high);
                if (dictionary.containsKey(curr)) {
                    if (rem.containsKey(curr)) {
                        if (rem.get(curr) == 1) rem.remove(curr);
                        else rem.put(curr, rem.get(curr) - 1);
                    }
                    found.put(curr, found.getOrDefault(curr, 0) + 1);
                }
                
                high++;
                // System.out.println("expanding " + s.substring(low, high));
                // System.out.println("found " + found);
                // System.out.println("rem " + rem);
                
            }
            //System.out.println("before update" + " rem " + rem);
            if (rem.size() == 0 && high - low <= len) {
                bestL = low;
                bestH = high;
                len = high - low;
                //System.out.println("update low " + low + " high " + high + " currLen " + len);
            }
            char atLow = s.charAt(low);
            if (dictionary.containsKey(atLow)) {
                if (found.containsKey(atLow)) {
                    if (found.get(atLow) == 1) {
                        found.remove(atLow);
                        rem.put(atLow, rem.getOrDefault(atLow, 0) + 1);
                    } else {
                        found.put(atLow, found.get(atLow) - 1);
                        int toPut = dictionary.get(atLow) - found.get(atLow);
                        if (toPut > 0) rem.put(atLow, toPut);
                    }
                    
                }
            }
            low++;
        //     System.out.println("shrinking " + s.substring(low, high));
        //     System.out.println("found " + found);
        //     System.out.println("rem " + rem);
        }
        
        return s.substring(bestL, bestH);
    }
}