class Solution {
    public int maxProfit(int k, int[] prices) {
        
        // int [][][] dp = new int[prices.length][2][k];
        // for(int i  = 0 ; i<prices.length;i++){
        //     for(int j = 0 ; j<=1 ; j++){
        //         Arrays.fill(dp[i][j],-1);
        //     }
        // }

        // return maxStock(0,1,k-1,prices,dp);

        return maxStcokDp(k , prices);
         
    }
    public int maxStock(int idx ,int buy, int cap, int []prices, int dp[][][]){
        if(idx==prices.length || cap<0){
            return 0;
        }
        
        if(dp[idx][buy][cap]!=-1){
            return dp[idx][buy][cap];
        }
        int profit = 0;
        if(buy==1){
            profit =Math.max(-prices[idx]+ maxStock(idx+1,0,cap,prices, dp) , maxStock(idx+1,1,cap,prices,dp));
        }else{
            profit = Math.max(prices[idx]+ maxStock(idx+1,1,cap-1,prices, dp),  maxStock(idx+1,0,cap,prices, dp));
        }
        
        return profit;
    }

    public int maxStcokDp(int k,  int []prices){

        int [][][]dp = new int[prices.length+1][2][k+1];


        for(int i = prices.length -1 ; i>=0 ; i--){
            for(int  j = 0  ; j<=1 ; j++){
                for(int c = 1; c<=k ; c++){
                    if(j==1){
                  dp[i][j][c]= Math.max(-prices[i]+ dp[i+1][0][c] , 0 +dp[i+1][1][c]);
                }else{
                  dp[i][j][c] = Math.max(prices[i]+dp[i+1][1][c-1] , 0 +dp[i+1][0][c]);
                }
                }
            }

        }
            return dp[0][1][k];
    }


}