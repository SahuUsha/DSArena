class Solution {
    public int maxProfit(int[] prices) {
        // Code here
        
        int buy = prices[0];
        int max = 0;
        
        for(int i = 1; i<prices.length ;i++){
          int cost = prices[i] - buy;
            max  = Math.max(max,cost);
            buy = Math.min(buy,prices[i]);
        }
        
        return max;
    }
}