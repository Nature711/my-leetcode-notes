class Solution {
    
    public boolean isHappy(int n) {
        int num = n;
        HashSet<Integer> seen = new HashSet<>();
        while (true) {
            int res = 0;
            while (num > 0) {
                
                res += (int) Math.pow(num % 10, 2);
                num /= 10;
            }
            
            if (res == 1) return true;
            if (seen.contains(res)) return false;
            seen.add(res);
            num = res;
        }
        
    }
}