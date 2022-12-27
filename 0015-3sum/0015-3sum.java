class Solution {
    int[] arr;
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        arr = nums;
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            HashSet<List<Integer>> twoSumRes = twoSum(-nums[i], i + 1, n - 1);
            for (List<Integer> ts: twoSumRes) {
                List<Integer> numList = new ArrayList<>();
                numList.add(ts.get(0));
                numList.add(ts.get(1));
                numList.add(nums[i]);
                res.add(numList);
            }

        }
        return res;
    }
    
    public HashSet<List<Integer>> twoSum(int target, int low, int high) {
        HashSet<List<Integer>> res = new HashSet<>();
        while (low < high) {
            int currSum = arr[low] + arr[high];
            if (currSum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[low]);
                list.add(arr[high]);
                res.add(list);
                low++;
                high--;
            } else if (currSum < target) low++;
            else high--;
        }
        return res;
    }
    
        
        
}