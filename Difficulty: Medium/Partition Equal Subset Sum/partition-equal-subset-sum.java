class Solution {
    static boolean equalPartition(int arr[]) {
        
        // code here
     int totalSum = 0;
     for(int i = 0 ; i<arr.length ; i++){
         totalSum  += arr[i];
     }
     if(totalSum%2!=0){
         return false;
     }
     
     int tar = totalSum/2;
     
     
     return equalPart(arr,tar);
        
    }
    
    public static boolean equalPart(int arr[], int tar){
        
    boolean dp[][] =  new boolean[arr.length][tar+1];
        
    for(int i = 0 ; i<arr.length ;i++){
        dp[i][0] = true;
    }
    
    if(arr[0]<=tar){
        dp[0][arr[0]] = true;
    }
    
    for(int i = 1  ; i<arr.length ; i++){
        for(int j = 0 ; j<=tar ; j++){
            if(j-arr[i]>=0){
                dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]];
            }else{
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    
   return dp[arr.length-1][tar];
    }
}