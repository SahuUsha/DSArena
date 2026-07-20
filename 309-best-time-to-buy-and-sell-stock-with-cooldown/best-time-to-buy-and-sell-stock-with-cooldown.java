class Solution {
    public int maxProfit(int[] prices) {

        int dp[][] = new int[prices.length][2];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        
        return sellcool(0,1,prices,dp);
    }
    public int sellcool(int idx, int buy, int []prices , int [][]dp){
         if(idx>=prices.length){
            return 0;
         }

         if(dp[idx][buy]!=-1){
            return dp[idx][buy];
         }

         int profit =0;

         if(buy==1){
            profit = Math.max(-prices[idx]+sellcool(idx+1 ,0,prices,dp),sellcool(idx+1,1,prices,dp));
         }else{
            profit =  Math.max(prices[idx]+sellcool(idx+2 ,1,prices,dp),sellcool(idx+1,0,prices,dp));
         }

         return dp[idx][buy] = profit;
    }

}