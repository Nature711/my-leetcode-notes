class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        
        for (int i = 0; i < spells.length; i++) {
            int low = 0, high = n - 1;
            //index of the first number that's >= success
            while (low < high) {
                int mid = low + (high - low) / 2;
                if ((long)Math.ceil((1.0*success)/spells[i]) <= potions[mid]) high = mid;
                else low = mid + 1;
            }
            if (low == n - 1 && ((long)Math.ceil((1.0*success)/spells[i]) > potions[low])) low++;
            spells[i] = n - low;
        }
        
        return spells;
    }

}
