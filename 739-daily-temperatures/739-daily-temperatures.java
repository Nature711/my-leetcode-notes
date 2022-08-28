class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            int currTemp = temperatures[i];
            int k = 1;
            while (i + k < n && currTemp >= temperatures[i + k]) k++;
            res[i] = (i + k == n) ? 0 : k;
        }
        
        return res;
    }
}