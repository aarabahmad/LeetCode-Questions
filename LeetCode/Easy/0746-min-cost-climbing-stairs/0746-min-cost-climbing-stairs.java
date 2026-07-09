class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length+1];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<=cost.length;i++) {
            int costs=i>cost.length-1?0:cost[i];
            dp[i]=Math.min(dp[i-2]+costs, dp[i-1]+costs);
        }
        return dp[dp.length-1];
    }
}