class Solution {
    static boolean isSubsetSum(int arr[], int sum) {
        // code here
        return  subsetSum(arr,sum);
        
    }
    
    public static boolean subsetSum(int arr[] , int sum){
        
        boolean dp[][] = new boolean[arr.length][sum+1];
        
        for(int  i =  0 ; i<arr.length ; i++){
            dp[i][0] = true;
        }
        
        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }
        
        for(int i = 1 ; i<arr.length ; i++){
            for(int j = 0 ; j<=sum ; j++){
                if(j-arr[i]>=0){
                dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]];
                }else{
                    dp[i][j]  = dp[i-1][j];
                }
            }
        }
         
        return dp[arr.length-1][sum];
    }
    
    
}