## HashMap & PQ
```
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
 ```
 - build map: O(n) 
 - build pq: O(nlogn)
 - build string: O(n)

## Bucket sort
```
public String frequencySort(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        
        HashMap<Integer, List<Character>> buckets = new HashMap<>();
        
        for (char c: map.keySet()) {
            int freq = map.get(c);
            if (buckets.containsKey(freq)) {
                buckets.get(freq).add(c);
            } else {
                List<Character> list = new ArrayList<>();
                list.add(c);
                buckets.put(freq, list);
            }
        }
     
        String res = "";
        
        for (int freq = s.length(); freq > 0; freq--) {
            if (buckets.containsKey(freq)) {
                List<Character> list = buckets.get(freq);
                for (int i = 0; i < list.size(); i++) {
                    if (res.length() == s.length()) return res;
                    int f = freq;
                    char c = list.get(i);
                    while (f > 0) {
                        res += c;
                        f--;
                    }
                }
            }
            if (res.length() == s.length()) return res;
        }
     
        return res;
    }
```
