class Solution {
    public int smallestCommonElement(int[][] mat) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: mat[0]) set.add(num);
        
        for (int i = 1; i < mat.length; i++) {
            HashSet<Integer> newSet = new HashSet<>();
            for (int j = 0; j < mat[0].length; j++) {
                if (set.contains(mat[i][j])) newSet.add(mat[i][j]);
            }
            set = newSet;
        }
        
        int min = Integer.MAX_VALUE;
        for (int num: set) min = Math.min(min, num);
        
        return min == Integer.MAX_VALUE ? -1: min;
    }
    
}