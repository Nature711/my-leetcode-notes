class Solution {
    public boolean canChange(String start, String target) {
        List<Pair<Integer, Character>> s = new ArrayList<>(), t = new ArrayList<>();
        
        for (int i = 0; i < start.length(); i++) {
            char sc = start.charAt(i), st = target.charAt(i);
            if (sc != '_') s.add(new Pair<>(i, sc));
            if (st != '_') t.add(new Pair<>(i, st));
        }
        
        if (s.size() != t.size()) return false;
        
        for (int i = 0; i < s.size(); i++) {
            Pair<Integer, Character> ss = s.get(i), tt = t.get(i);
            if (ss.getValue() != tt.getValue()) return false;
            
            if (ss.getValue() == 'L' && ss.getKey() < tt.getKey()) return false;
            if (ss.getValue() == 'R' && ss.getKey() > tt.getKey()) return false;
        }
        
        return true;
    }
}