class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        int dx = coordinates[1][0] - coordinates[0][0];
        
        if (dx == 0) {
            int x = coordinates[0][0];
            for (int i = 2; i < coordinates.length; i++) if (coordinates[i][0] != x) return false;
            return true;
        }
        
        double gradient = (double) (coordinates[1][1] - coordinates[0][1]) / dx;
     
        for (int i = 2; i < coordinates.length; i++) {
            int currDx = coordinates[i][0] - coordinates[i - 1][0];
            if (currDx == 0) return false;
            double currGradient =  (double) (coordinates[i][1] - coordinates[i - 1][1]) / currDx;
   
            if (currGradient != gradient) return false;
        }
        
        return true;
    }
}