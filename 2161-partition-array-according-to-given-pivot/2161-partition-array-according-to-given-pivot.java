class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int len = nums.length;
        
        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();
        int pivotCount = 0;
        
        for (int i = 0; i < len; i++) {
            if (nums[i] == pivot) {
                pivotCount++;
            } else if (nums[i] < pivot) {
                small.add(nums[i]);
            } else {
                large.add(nums[i]);
            }
        }
        
        int i = 0;
        for (int j = 0; j < small.size(); j++) {
            nums[i] = small.get(j);
            i++;
        }
        
        for (int j = 0; j < pivotCount; j++) {
            nums[i] = pivot;
            i++;
        }
        
        for (int j = 0; j < large.size(); j++) {
            nums[i] = large.get(j);
            i++;
        }
        
        return nums;
    }
}