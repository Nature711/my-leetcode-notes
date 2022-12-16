class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_surplus = 0;
        int surplus = 0;
        int start = 0;
        
        for(int i = 0; i < n; i++) total_surplus += gas[i] - cost[i];
        if (total_surplus < 0) return -1;
        
        for (int i = 0; i < n; i++) {
            surplus += gas[i] - cost[i];
            if (surplus < 0) {
                surplus = 0;
                start = i + 1;
            }
        }
        return start;
    }
    
}