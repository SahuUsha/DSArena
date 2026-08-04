class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        
    //   int dp[]
    
    // return findMax(arr, 0,0);
    return tabulation(arr);
      
      
    }
    
    public int findMax(int arr[] , int idx , int sum){
        
        if(idx>=arr.length){
            return sum;
        }
        
        
        int notTake = findMax(arr,idx+1, sum);
        
        int take = findMax(arr,idx+2, sum+arr[idx]);
        
        return Math.max(notTake,take);
    }
    
    public int tabulation(int arr[]){
        
        int dp[] = new int[arr.length];
        
        dp[arr.length-1] = arr[arr.length-1];
        
        for(int  i =arr.length-2 ; i>=0 ; i--){
            int notTake = dp[i+1];
            
            int take= arr[i];
            if(i+2<dp.length){
                take += dp[i+2];
            }
            
            dp[i] = Math.max(notTake,take);
        }
        
        return dp[0];
        
    }
}