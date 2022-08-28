class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] nextGreatest = new int[nums2.length];
        map.put(nums2[0], 0);
        stack.push(0);
        
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int idx = stack.pop();
                nextGreatest[idx] = nums2[i];
            }
            stack.push(i);
            map.put(nums2[i], i);
        }
        
        while(!stack.isEmpty()) nextGreatest[stack.pop()] = -1;
        
        int[] res = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                int idx = map.get(nums1[i]);
                res[i] = nextGreatest[idx];
            }
        }
        
        return res;
    }
}