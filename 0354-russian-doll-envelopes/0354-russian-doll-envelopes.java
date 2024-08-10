class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            return a[0] == b[0] ? 
                b[1] - a[1] : a[0] - b[0];
        });
        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = envelopes[i][1];
        return lengthOfLIS(height);
    }
    
    public int lengthOfLIS(int[] nums) {
        int[] decks = new int[nums.length];
        int numDecks = 0;
        for (int num: nums) {
            int low = 0, high = numDecks; 
            while (low < high) { // find the leftmost element whose >= num
                int mid = low + (high - low) / 2;
                if (decks[mid] >= num) high = mid;
                else low = mid + 1;
            }
            if (decks[low] >= num) decks[low] = num;
            else {
                decks[numDecks] = num;
                numDecks++;
            }
        }
        return numDecks;
    }
}