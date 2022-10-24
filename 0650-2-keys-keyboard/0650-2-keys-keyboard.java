class Solution {
    public int minSteps(int n) {
        
        int steps = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                steps += 2;
                n /= 2;
            } else {
                int div = findDivisor(n);
                if (div == -1) return steps + n;
                else {
                    steps += div;
                    n /= div;
                }
            }
        }
        
        return steps;
    }
    
    
    public int findDivisor(int n) {
        for (int i = 3; i < n / 2; i++) if (n % i == 0) return i;
        return -1;
    }
    
}