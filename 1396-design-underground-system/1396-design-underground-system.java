class UndergroundSystem {
    
    HashMap<Pair<String, String>, Pair<Double, Integer>> map;
    HashMap<Integer, Pair<String, Integer>> starts;

    public UndergroundSystem() {
        map = new HashMap<>();
        starts = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        starts.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> info = starts.get(id);
        String startStation = info.getKey();
        int checkinTime = info.getValue();
        starts.remove(id);
        Pair<String, String> startToEnd = new Pair<>(startStation, stationName);
        double travellingTime = t - checkinTime;
        if (map.containsKey(startToEnd)) {
            Pair<Double, Integer> sumCount = map.get(startToEnd);
            Pair<Double, Integer> updatedSumCount = 
                new Pair<>(sumCount.getKey() + travellingTime, sumCount.getValue() + 1);
            map.put(startToEnd, updatedSumCount);
        } else {
            map.put(startToEnd, new Pair<>(travellingTime, 1));
        }
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<Double, Integer> sumCount = map.get(new Pair<>(startStation, endStation));
        return sumCount.getKey() / sumCount.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */