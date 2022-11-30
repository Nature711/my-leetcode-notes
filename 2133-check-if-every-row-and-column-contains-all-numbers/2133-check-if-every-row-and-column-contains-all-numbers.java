class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        
        List<HashSet<Integer>> rows = new ArrayList<>();
        List<HashSet<Integer>> cols = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rows.get(i).add(matrix[i][j]);
                cols.get(j).add(matrix[i][j]);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (rows.get(i).size() != n) return false;
            if (cols.get(i).size() != n) return false;
        }
        
        return true;
    }
}