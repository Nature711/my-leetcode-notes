class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int m = adjacentPairs.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int first = adjacentPairs[i][0], second = adjacentPairs[i][1];
            if (!map.containsKey(first)) {
                map.put(first, new ArrayList<>());
            }
            map.get(first).add(i);
            if (!map.containsKey(second)) {
                map.put(second, new ArrayList<>());
            }
            map.get(second).add(i);
        }
        int curr = 0;
        for (int num: map.keySet()) {
            if (map.get(num).size() == 1) {
                curr = num;
                break;
            }
        }
        int n = map.size();
        int fromIdx = -1;
        List<Integer> res = new ArrayList<>();
        res.add(curr);
        
        while (res.size() < n) {
            List<Integer> indices = map.get(curr);
            int idx = -1;
            if (indices.size() == 1) {
                idx = indices.get(0);
            } else {
                int idx1 = indices.get(0), idx2 = indices.get(1);
                if (idx1 == fromIdx) idx = idx2;
                else idx = idx1;
            }
            fromIdx = idx;
            int[] pair = adjacentPairs[idx];
            if (curr == pair[0]) {
                curr = pair[1];
            } else {
                curr = pair[0];
            }
            res.add(curr);
        }
        int[] resArray = new int[n];
        for (int i = 0; i < n; i++) resArray[i] = res.get(i);
        return resArray;
    }
    
    
}