class WordDistance {
    
    HashMap<String, List<Integer>> indices = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        
        for (int i = 0; i < wordsDict.length; i++) {
            if (!indices.containsKey(wordsDict[i])) indices.put(wordsDict[i], new ArrayList<>());
            indices.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = indices.get(word1);
        List<Integer> l2 = indices.get(word2);
        int i = 0, j = 0, minDistance = Integer.MAX_VALUE;
        while (i < l1.size() && j < l2.size()) {
            minDistance = Math.min(minDistance, Math.abs(l1.get(i) - l2.get(j)));
            if (l1.get(i) < l2.get(j)) i++;
            else j++;

        }
        return minDistance;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */