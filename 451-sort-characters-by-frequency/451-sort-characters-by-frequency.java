class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((p1, p2) -> p2.getValue() - p1.getValue());
        
        for (char c: map.keySet()) {
            pq.add(new Pair<>(c, map.get(c)));
        }
        
        String res = "";
        while (!pq.isEmpty()) {
            Pair<Character, Integer> currP = pq.poll();
            int freq = currP.getValue();
            char c = currP.getKey();
            while (freq > 0) {
                res += c;
                freq--;
            }
        }
        return res;
        
    }
}