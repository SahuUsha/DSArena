class Solution {
    public int maxProfit(int[] prices) {

        int dp[][][] = new int[prices.length+1][2][2];
        for(int i=0;i<prices.length;i++){
             for(int j=0;j<2;j++){
         Arrays.fill(dp[i][j],-1);
        }
        }
       
       return  stockBuy(0,1,1,prices,dp);

    }

    public int stockBuy(int idx, int buy, int cap, int []prices, int dp[][][]){
       if(cap<0) return 0;

        if(idx>=prices.length){
            return 0;

        }

        if(dp[idx][buy][cap]!=-1){
            return dp[idx][buy][cap];
        }
        
        int profit = 0;
        if(buy==1){
          profit = Math.max(-prices[idx] +stockBuy(idx+1,0,cap,prices,dp) ,  stockBuy(idx+1,1,cap,prices,dp));
        }else{
            profit = Math.max(prices[idx]+ stockBuy(idx+1,1,cap-1,prices,dp), stockBuy(idx+1,0,cap,prices,dp));
        }

        dp[idx][buy][cap] = profit;
        return dp[idx][buy][cap];
    }


}