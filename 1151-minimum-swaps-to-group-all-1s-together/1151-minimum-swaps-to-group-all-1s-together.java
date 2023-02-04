class Solution {
    
    public int minSwaps(int[] data) {
        int n = data.length, ones = 0;
        for (int num: data) if (num == 1) ones++;
        if (ones == 1) return 0;
        
        int low = 0, high = ones - 1, onesInWindow = 0, minSwaps = n;
        while (high < n) {
            if (low == 0) {
                for (int i = low; i <= high; i++) if (data[i] == 1) onesInWindow++;
            } else {
                if (data[low - 1] == 1) onesInWindow--;
                if (data[high] == 1) onesInWindow++;
            }
           // System.out.println("current window: low " + low + " high " + high + " has ones " + onesInWindow);
            minSwaps = Math.min(minSwaps, ones - onesInWindow);
            low++;
            high++;
        }
        return minSwaps;
    }
 
    
}