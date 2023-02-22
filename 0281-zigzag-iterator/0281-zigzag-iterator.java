public class ZigzagIterator {
    
    boolean isListOneTurn;
    int i, j;
    List<Integer> list1, list2;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        isListOneTurn = true;
        i = 0;
        j = 0;
        list1 = v1;
        list2 = v2;
    }

    public int next() {
        if (i == list1.size()) return list2.get(j++);
        if (j == list2.size()) return list1.get(i++);
        
        int res = isListOneTurn ? list1.get(i++) : list2.get(j++);
        isListOneTurn = !isListOneTurn;
        return res;
    }

    public boolean hasNext() {
        return !(i == list1.size() && j == list2.size());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */