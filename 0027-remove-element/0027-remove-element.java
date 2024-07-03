class Solution {
    public int removeElement(int[] nums, int val) {
        int front = 0, back = nums.length - 1;
        while (front <= back) {
            if (nums[front] == val) {
                nums[front] = nums[back];
                back--;
            }
            if (nums[front] != val) front++;
        }
        return back + 1;
    }
}