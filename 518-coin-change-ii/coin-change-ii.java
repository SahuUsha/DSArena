class Solution {
    public int change(int amount, int[] coins) {
        
         return spaceoptimization(coins,amount);
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