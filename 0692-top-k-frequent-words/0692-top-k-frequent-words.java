class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair<String, Integer>> pq = 
            new PriorityQueue<>((p1, p2) -> {
                int deltaFreq = p2.getValue() - p1.getValue();
                if (deltaFreq == 0) return p1.getKey().compareTo(p2.getKey());
                else return deltaFreq;
            });
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        System.out.println(map);
        
        for (String word: map.keySet()) pq.add(new Pair<>(word, map.get(word)));
        
        List<String> res = new ArrayList<>();
        
        while (k-- > 0) res.add(pq.poll().getKey());
        
        return res;
        
    }
}