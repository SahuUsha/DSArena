class Solution {
    public int maxProfit(int[] prices) {
        // Code here
        
        return maxProfit1(prices);
        
    }
    
    public int maxProfit1(int []prices){
        
        int minPrices = prices[0];
        int profit = 0;
        
        for(int  i =1 ; i<prices.length ; i++){
            minPrices = Math.min(minPrices,prices[i]);
            profit = Math.max(profit, prices[i]-minPrices);
            
        }
        return profit;
        
    }
    
//   public int maxProfitTabulate(int[] prices) {

//       int n = prices.length;
//       int dp[][] = new int[n][n];

//       // Buy on day 0
//       for(int j = 1; j < n; j++) {
//           dp[0][j] = Math.max(dp[0][j-1], prices[j] - prices[0]);
//       }

//       for(int i = 1; i < n; i++) {

//           for(int j = i + 1; j < n; j++) {

//               dp[i][j] = Math.max(
//                   dp[i-1][j],
//                   Math.max(
//                       dp[i][j-1],
//                       prices[j] - prices[i]
//                   )
//               );
//           }
//       }

//       return dp[n-1][n-1];
//   }
}