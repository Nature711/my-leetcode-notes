class Solution {
    public int maxArea(int[] height) {
        int n = height.length, low = 0, high = n - 1, maxArea = 0;
        while (low < n && high >= 0) {
            int area = (high - low) * Math.min(height[low], height[high]);
            maxArea = Math.max(maxArea, area);
            if (height[low] < height[high]) low++;
            else high--;
        }
        return maxArea;
    }
}