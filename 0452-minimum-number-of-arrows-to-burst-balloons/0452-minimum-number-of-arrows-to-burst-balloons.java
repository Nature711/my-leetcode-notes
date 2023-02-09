class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int arrows = 1;
        long end = points[0][1];
        for (int[] balloon: points) {
            if (balloon[0] <= end) continue;
            arrows++;
            end = balloon[1];
        }
        return arrows;
    }
    
}