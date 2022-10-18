class Solution {
    int target;
    HashMap<String, Boolean> memo = new HashMap<>();
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int num: nums) sum += num;
        
        if (sum % k != 0) return false;
        target = sum / k;
        
        char[] taken = new char[n]; 
        for (int i = 0; i < n; i++) taken[i] = '0';
        
        return backtrack(0, nums, k, 0, taken);
    }
    
    public boolean backtrack(int idx, int[] arr, int k, int currSum, char[] taken) {
         String takenStr = new String(taken);
        if (k == 1) return true;
        
        if (currSum > target) return false;
        
        if (memo.containsKey(takenStr)) return memo.get(takenStr);
        
        if (currSum == target) {
            boolean ans = backtrack(0, arr, k - 1, 0, taken);
            
            memo.put(takenStr, ans);
            
            return ans;
        }
        
        for (int i = idx; i < arr.length; i++) {
            
            if (taken[i] == '0') {
                
                taken[i] = '1';
                
                if (backtrack(i + 1, arr, k, currSum + arr[i], taken)) return true;
                
                taken[i] = '0';
            }
            
        }
        
        return false;
    }
}