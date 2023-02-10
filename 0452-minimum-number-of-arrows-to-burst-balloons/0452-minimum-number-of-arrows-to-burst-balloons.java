class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[0], p2[0]));
        int count = 1;
        int minEnd = points[0][1];
        for (int[] inv: points) {
            if (inv[0] <= minEnd) {
                minEnd = Math.min(minEnd, inv[1]);
            } else {
                count++;
                minEnd = inv[1];
            }
        }
        
        return count;
    }
    
}