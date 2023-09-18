class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1.getKey() - p2.getKey() != 0) {
                return p1.getKey() - p2.getKey();
            } else {
                return p1.getValue() - p2.getValue();
            }
        });
        for (int i = 0; i < m; i++) {
            int lastSoldierIdx = findLastSoldierInRow(mat, i);
            pq.add(new Pair<>(lastSoldierIdx + 1, i));
            //System.out.println(pq);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getValue();
        }
        return res;
    }
    
    int findLastSoldierInRow(int[][] mat, int row) {
        int[] arr = mat[row];
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (arr[mid] == 0) high = mid - 1;
            else low = mid;
        }
        return arr[low] == 1 ? low : -1;
    }

}