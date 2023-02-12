class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        int maxLen = 0;
        
        for (int num: nums) {
            if (!set.contains(num)) continue;
            int base = num;
            int curr = base, currLen = 1;
            while (set.contains(++curr)) {
                currLen++;
                set.remove(curr);
            }
            curr = base;
            while (set.contains(--curr)) {
                currLen++;
                set.remove(curr);
            }
            maxLen = Math.max(maxLen, currLen);
        }
        
        return maxLen;
    }
}