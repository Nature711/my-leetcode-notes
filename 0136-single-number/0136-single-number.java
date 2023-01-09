class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }
        int res = 0;
        for (int n: set) {
            res = n;
            break;
        }
        return res;
    }
}