class Solution {
    public int maxProfit(int[] prices) {

    //     int dp[][][] = new int[prices.length+1][2][2];
    //     for(int i=0;i<prices.length;i++){
    //          for(int j=0;j<2;j++){
    //      Arrays.fill(dp[i][j],-1);
    //     }
    //     }
       
    //    return  stockBuy(0,1,1,prices,dp);

    return maxStcokDp(prices);
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

     public int maxStcokDp(int []prices){

        int [][][]dp = new int[prices.length+1][2][2+1];


        for(int i = prices.length -1 ; i>=0 ; i--){
            for(int  j = 0  ; j<=1 ; j++){
                for(int c = 1; c<=2 ; c++){
                    if(j==1){
                  dp[i][j][c]= Math.max(-prices[i]+ dp[i+1][0][c] , 0 +dp[i+1][1][c]);
                }else{
                  dp[i][j][c] = Math.max(prices[i]+dp[i+1][1][c-1] , 0 +dp[i+1][0][c]);
                }
                }
            }

        }
            return dp[0][1][2];
    }



}