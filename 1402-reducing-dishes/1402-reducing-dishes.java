class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int currSum = 0, delta = 0, t = 1;
        
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            delta += satisfaction[i];
            if (delta < 0) return currSum;
            currSum += delta;
            t++;
        }
        
        return currSum;
    }
}