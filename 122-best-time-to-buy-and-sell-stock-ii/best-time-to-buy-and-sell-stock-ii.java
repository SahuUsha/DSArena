class Solution {

    public int maxProfit(int[] prices) {
        

    //     int dp[][] = new int[prices.length][2];

    //     for(int d[] : dp){
    //         Arrays.fill(d,-1);
    //     }
      
    //   return f(0,1,prices,dp);

    return tabulation(prices);
    }

    public int f(int idx, int buy, int []prices, int dp[][]){
       if(idx==prices.length){
        return 0;
       }

        int profit = 0;

        if(dp[idx][buy]!=-1){
            return dp[idx][buy];
        }
        if(buy==1){
           profit = Math.max(-prices[idx] + f(idx+1,0,prices,dp) , 0+f(idx+1,1,prices,dp));
        }else{
            profit = Math.max(prices[idx]+ f(idx+1,1,prices,dp) , 0 + f(idx+1,0,prices,dp));
        }
      dp[idx][buy] = profit;
     return dp[idx][buy];
    }

    public int tabulation(int []prices){

        int dp[][] = new int[prices.length+1][2];

        dp[prices.length][0] = 0;
        dp[prices.length][1] = 0;

        for(int i = prices.length-1 ; i>=0; i--){
            int profit=0;
            for(int j = 0 ; j<=1 ; j++){

                if(j==1){
                    profit = Math.max(-prices[i]+ dp[i+1][0] , 0 +dp[i+1][1]);
                }else{
                    profit = Math.max(prices[i]+dp[i+1][1] , 0 +dp[i+1][0]);
                }

                dp[i][j] = profit;
            }
        }

        return dp[0][1];
    }


}