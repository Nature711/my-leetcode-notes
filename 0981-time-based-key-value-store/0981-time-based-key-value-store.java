class TimeMap {
    
    HashMap<String, List<Integer>> keyAndTimes;
    HashSet<String> keys;
    HashMap<Pair<String, Integer>, String> map;

    public TimeMap() {
        keyAndTimes = new HashMap<>();
        keys = new HashSet<>();
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keys.add(key);
        map.put(new Pair<>(key, timestamp), value);
        if (keyAndTimes.containsKey(key)) keyAndTimes.get(key).add(timestamp);
        else {
            List<Integer> times = new ArrayList<>();
            times.add(timestamp);
            keyAndTimes.put(key, times);
        }
    }
    
    public String get(String key, int timestamp) {
        
        if (!keys.contains(key)) return "";
        int t = timestamp;
        Pair<String, Integer> p = new Pair<>(key, t);
        
        List<Integer> tRange = keyAndTimes.get(key);
        if (tRange.size() == 1) {
            if (tRange.get(0) > timestamp) return "";
            else {
                p = new Pair<>(key, tRange.get(0));
                return map.get(p);
            }
        }
        //System.out.println("search " + timestamp  + " in " + tRange);
        int idx = searchClosest(tRange, timestamp);
        //System.out.println(idx);
        if (idx == -1) return "";
        p = new Pair<>(key, tRange.get(idx));
        return map.get(p);

    }
    
    public int searchClosest(List<Integer> nums, int target) {
        int low = 0, high = nums.size() - 1;
        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            if (nums.get(mid) < target) low = mid;
            else high = mid;
        }
        //at this point, low == high - 1
        if (target >= nums.get(high)) return high;
        if (target < nums.get(low)) return -1;
        else return low;
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */