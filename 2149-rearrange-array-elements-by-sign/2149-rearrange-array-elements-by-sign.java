class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int mid = n / 2;
        
        int[] ans = new int[n];
        int[] positive = new int[mid];
        int[] negative = new int[mid];
        int pos = 0;
        int neg = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                positive[pos++] = nums[i];
            } else {
                negative[neg++] = nums[i];
            }
        }
        
        for (int pLocal = 0, pGlobal = 0; pGlobal < n; pLocal++) {
            ans[pGlobal++] = positive[pLocal];
            ans[pGlobal++] = negative[pLocal];
        }
        
        return ans;
    }
    
}