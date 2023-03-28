class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int last = days[n - 1], first = days[0];
        int[] dp = new int[last + 2];
        dp[last + 1] = 0;
        dp[last] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        Set<Integer> travelDays = new HashSet<>();
        for (int day: days) travelDays.add(day);
        
        for (int d = last - 1; d >= first; d--) {
            if (!travelDays.contains(d)) {
                dp[d] = dp[d + 1];
                continue;
            }
        
            int oneDay = costs[0] + dp[Math.min(last + 1, d + 1)];
            int sevenDay = costs[1] + dp[Math.min(last + 1, d + 7)];
            int thirtyDay = costs[2] + dp[Math.min(last + 1, d + 30)];
            dp[d] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
            //System.out.println("day " + d + " cost " + dp[d]);
        }
        
        return dp[first];
        
    }
}