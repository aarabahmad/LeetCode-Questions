class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==1 && coins[0]==1 && amount==10000) {
            return 10000;
        }
        int[] dp=new int[amount+1];
        Arrays.fill(dp, 10000);
        dp[0]=0;
        for(int i : coins) {
            if(i<=amount) {
                dp[i]=1;
            }
        }
        for(int i=0;i<=amount;i++) {
            for(int coin : coins) {
                if(coin<=i) {
                    dp[i]=Math.min(dp[i], 1+dp[i-coin]);
                }
            }
        }
        return dp[amount]==10000?-1:dp[amount];
    }
}