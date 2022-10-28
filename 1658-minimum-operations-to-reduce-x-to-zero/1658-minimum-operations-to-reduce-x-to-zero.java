class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        HashMap<Integer, Integer> forward_sum_map = new HashMap<>();
        HashMap<Integer, Integer> backward_sum_map = new HashMap<>();
        int forward_sum = 0;
        int backward_sum = 0;
        
        for (int i = 0; i < n; i++) {
            forward_sum += nums[i];
            forward_sum_map.put(forward_sum, i + 1);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            backward_sum += nums[i];
            backward_sum_map.put(backward_sum, nums.length - i);
        }
        
        int minOp = n + 1;
        
        for (int f_sum: forward_sum_map.keySet()) {
            if (backward_sum_map.containsKey(x - f_sum)) {
                int op = forward_sum_map.get(f_sum) + backward_sum_map.get(x- f_sum);
                minOp = Math.min(minOp, op);                                                
            } 
        }
        
        for (int b_sum: backward_sum_map.keySet()) {
            if (forward_sum_map.containsKey(x - b_sum)) {
                int op = forward_sum_map.get(x - b_sum) + backward_sum_map.get(b_sum);
                minOp = Math.min(minOp, op);                                                
            } 
        }
        
        if (forward_sum_map.containsKey(x)) minOp = Math.min(minOp, forward_sum_map.get(x));
        
        if (backward_sum_map.containsKey(x)) minOp = Math.min(minOp, backward_sum_map.get(x));
        
        return minOp <= n ? minOp : -1;
        
    }
}