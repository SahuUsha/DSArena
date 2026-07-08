class Solution {
    public int count(int coins[], int sum) {
        // code here.
        
        // return count(coins,sum,0,0);
        
        // int dp[][] = new int[coins.length][sum+1];
        
    //     for(int d[] : dp){
    //         Arrays.fill(d,-1);
    //     }
        
    //   return memo(coins,sum,0,0,dp);
        
        // return tabulation(coins,sum);
        
        return spaceoptimization(coins,sum);
    }
    
    public int count(int []coins, int sum, int ans, int idx){

        if(ans==sum){
            return 1;
        }
        
        if(idx==coins.length || ans>sum){
            return 0;
        }
        
        int notTake = count(coins,sum,ans,idx+1);
        
        int take = count(coins,sum,ans+coins[idx],idx);
        
        return notTake + take;
    }
    
     public int memo(int []coins, int sum, int ans, int idx, int[][]dp){

        if(ans==sum){
            return 1;
        }
        
        if(idx==coins.length || ans>sum){
            return 0;
        }
        
        if(dp[idx][ans]!=-1){
            return dp[idx][ans];
        }
        
        int notTake = count(coins,sum,ans,idx+1);
        
        int take = count(coins,sum,ans+coins[idx],idx);
        
        return dp[idx][sum] = notTake + take;
    }
    
    
    public int tabulation(int []coins, int sum){
        int dp[][] = new int[coins.length+1][sum+1];
        
        for(int i = 0 ; i<=coins.length;i++){
            dp[i][sum]=1;
        }
        
       for (int idx = coins.length - 1; idx >= 0; idx--) {
        for (int s = sum - 1; s >= 0; s--) {

            int notTake = dp[idx + 1][s];

            int take = 0;
            if (s + coins[idx] <= sum) {
                take = dp[idx][s + coins[idx]];   
            }

            dp[idx][s] = notTake + take;
        }
    }

        
        return dp[0][0];
    }
    
    public int spaceoptimization(int []coins, int sum){
        
        int []next = new int[sum+1];
        int curr[] = new int[sum+1];
        
        next[sum] =1;
        
         for (int idx = coins.length - 1; idx >= 0; idx--) {
             curr[sum]=1;
        for (int s = sum - 1; s >= 0; s--) {

            int notTake = next[s];

            int take = 0;
            if (s + coins[idx] <= sum) {
                take = curr[s + coins[idx]];   
            }

            curr[s] = notTake + take;
        }
    next = curr.clone();
    }
    return next[0];
}
}
