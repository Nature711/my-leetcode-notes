class SmallestInfiniteSet {
    int currSmallest;
    PriorityQueue<Integer> recycleBin;

    public SmallestInfiniteSet() {
        recycleBin = new PriorityQueue<>();
        currSmallest = 1;
    }
    
    public int popSmallest() {
        if (recycleBin.isEmpty()) {
            int res = currSmallest++;
            return res;
        } else {
            return recycleBin.poll();
        }
    }
    
    public void addBack(int num) {
        if (num < currSmallest && !recycleBin.contains(num)) {
            recycleBin.add(num);
        } 
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */