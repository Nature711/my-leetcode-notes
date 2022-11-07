class Solution {
    public int maximum69Number (int num) {
        char[] nums = ("" + num).toCharArray();
        for (int i = 0; i < nums.length; i++) {
            if (((int)(nums[i] - '0')) == 6) {
                nums[i] = (char) (9 + '0');
                break;
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += ((int)(nums[nums.length - 1 - i]) - '0') * Math.pow(10, i);
        }
        return res;
    }
}