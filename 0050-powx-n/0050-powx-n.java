class Solution {
    public double myPow(double x, int n) {
        if (n > 0) return helper(x, n);
        else return 1/ helper(x, -n);
    }
    
    public double helper(double x, int n) {
        if (n == 0) return 1;
        double tmp = helper(x, n / 2);
        double res = tmp * tmp * ((n % 2 == 0) ? 1 : x);
        return res;
    }
}