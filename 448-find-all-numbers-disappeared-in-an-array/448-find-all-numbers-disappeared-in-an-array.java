class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 1];
        for (int i = 0; i < nums.length; i++) arr[nums[i]] = 1;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) res.add(i);
        }
        return res;
    }
}