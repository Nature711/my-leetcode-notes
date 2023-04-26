class Solution {
    public int addDigits(int num) {
        while (num > 9) {
            int temp = num;
            List<Integer> digits = new ArrayList<>();
            while (temp > 0) {
                digits.add(temp % 10);
                temp /= 10;
            }
            int sum = 0;
            for (int digit: digits) sum += digit;
            num = sum;
            
        }
        return num;
    }
}