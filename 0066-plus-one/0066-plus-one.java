class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
        int[] one = new int[n];
        one[n - 1] = 1;
        List<Integer> res = new ArrayList<>();
        
        int actual = 0;
        int sum = 0;
        int carry = 0;
        int i = n;
        
        while (--i >= 0) {
            actual = digits[i] + one[i] + carry;
            sum = actual % 10;
            carry = actual > 9 ? 1 : 0;
            res.add(sum);
        }
        
        if (carry == 1) res.add(1);
        
        int[] resArray = new int[res.size()];
        
        for (int j = 0; j < res.size(); j++) resArray[j] = res.get(res.size() - j - 1);
        
        return resArray;
    }
}