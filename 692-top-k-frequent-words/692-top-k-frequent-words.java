class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String word: words) {
            if (map.containsKey(word)) map.put(word, map.get(word) + 1);
            else map.put(word, 1);
        }
        
        Map<Integer, PriorityQueue<String>> frequencyTable = new HashMap<>();
        
        for (String word: map.keySet()) {
            int frequency = map.get(word);
            if (frequencyTable.containsKey(frequency)) {
                frequencyTable.get(frequency).add(word);
            } else {
                PriorityQueue<String> dictionary = new PriorityQueue<>();
                dictionary.add(word);
                frequencyTable.put(frequency, dictionary);
            }
        }
        
        List<String> res = new ArrayList<>();
        
        for (int freq = words.length; freq > 0; freq--) {
            if (frequencyTable.containsKey(freq)) {
                PriorityQueue<String> dictionary = frequencyTable.get(freq);
                while (res.size() < k && !dictionary.isEmpty()) {
                    res.add(dictionary.poll());
                }
            }
        }
        
        return res;
    }
}