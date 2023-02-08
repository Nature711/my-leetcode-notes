class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int arrows = 1;
        long end = points[0][1];
        // for(int[] point: points) System.out.println("[" + point[0] + "," + point[1] + "]");
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) continue;
            end = points[i][1];
            arrows++;
        }
        
        return arrows;
    }
    
}