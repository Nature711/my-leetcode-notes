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
        List<Stack<Integer>> decks = new ArrayList<>();
        for (int num: nums) {
            // determine if num can fit into any existing deck 
            int low = 0, high = decks.size();
            while (low < high) { // find the leftmost deck whose top > num
                int mid = low + (high - low) / 2; 
                if (decks.get(mid).peek() >= num) high = mid;
                else low = mid + 1;
            }
            if (low == decks.size()) {
                decks.add(new Stack<>());
                decks.get(decks.size() - 1).push(num);
            } else {
                decks.get(low).push(num);
            }
        }
        return decks.size();
    }
}