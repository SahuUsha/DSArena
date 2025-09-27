class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        // for(int  i =0 ; i<prices.length ;i++){
        //        int buy =  prices[i];
        //        for(int  j = i+1 ; j<prices.length ; j++){
        //          int profit = prices[j]-buy;
        //             if(maxProfit < profit){
        //                 maxProfit = profit;
        //             }
        //        }
               

        // }
        // return maxProfit; 
        int buy = prices[0] ;
      
        for(int i = 0 ;i<prices.length;i++){
        int cost = prices[i] - buy;
        maxProfit = Math.max(cost, maxProfit);
        buy = Math.min(buy,prices[i]);
    }
    return maxProfit;
    }
    }
