class Solution {
    public String stringShift(String s, int[][] shift) {
        int net = 0;
        for (int[] sh: shift) {
            if (sh[0] == 0) net += sh[1];
            else net -= sh[1];
        }
        
        int n = s.length();
        net = net % n;
        StringBuilder res = new StringBuilder();
        
        if (net > 0) {
            res.append(s.substring(net, n));
            res.append(s.substring(0, net));
            
        } else {
            net = -net;
            res.append(s.substring(n - net, n));
            res.append(s.substring(0, n - net));
        }
        return res.toString();
        
    }
}