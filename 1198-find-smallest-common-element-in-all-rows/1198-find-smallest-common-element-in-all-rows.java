class Solution {
    public int smallestCommonElement(int[][] mat) {
        int[] counts = new int[10001];
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                counts[mat[i][j]]++;
            }
        }
        
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == mat.length) return i;
        }
        
        return -1;
    }
    
}