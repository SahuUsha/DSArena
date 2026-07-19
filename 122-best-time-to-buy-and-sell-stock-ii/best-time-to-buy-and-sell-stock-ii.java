class Solution {

    public int maxProfit(int[] prices) {
        

        int dp[][] = new int[prices.length][2];

        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
      
      return f(0,1,prices,dp);
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
}