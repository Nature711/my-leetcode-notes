class Solution {
    public double average(int[] salary) {
        double sum = 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int s: salary) {
            sum += s;
            max = Math.max(s, max);
            min = Math.min(s, min);
        }
        
        return (sum - max - min) / (salary.length - 2);
        
    }
}