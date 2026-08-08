class Solution {
    static int perfectSum(int[] arr, int target) {
        // code here
        
        return tabulation(arr,target);
    }
    static int tabulation(int []arr , int target){
        
        int dp[][] = new int[arr.length][target+1];
        
        for(int i =0 ; i<arr.length ;i++){
            dp[i][0] =  1;
        }
        
        if(arr[0]==0){
            
            dp[0][0] = 2;
        }else{
        if(arr[0]<=target){
            dp[0][arr[0]] = 1;
        }
        }
        
        for(int i = 1 ; i<arr.length ; i++){
            for(int  j = 0 ; j<= target ; j++){
                
                int notTake = dp[i-1][j];
                
                int take= 0;
                if(arr[i]<=j){
                    take = dp[i-1][j-arr[i]];
                }
                
                dp[i][j] = take + notTake;
            }
        }
        
      return dp[arr.length-1][target];
    }
}