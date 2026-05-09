class Solution {
    public int countWays(int n) {
        // code here
        
        int dp[] = new int[n+1];
        for(int i = 0 ; i<=n; i++){
            dp[i] = -1;
        }
        
        return countWay(n,dp);
    }
    
   public static int countWay(int n , int dp[]){
       
       if(n==0){
         return 1;
       }
       
       
       if(n<0){
           return 0;
       }
       
       
       if(dp[n]!=-1){
           return dp[n];
       }
       
       
       dp[n] =  countWay(n-1,dp) + countWay(n-2,dp);
       return dp[n];
   }
}