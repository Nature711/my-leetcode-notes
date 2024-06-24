class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num: nums) {
            if (set.add(num)) list.add(num);
        }
        
        int i = 0;
        while (i < set.size()) {
            nums[i] = list.get(i);
            i++;
        }
        return set.size();
    }
}