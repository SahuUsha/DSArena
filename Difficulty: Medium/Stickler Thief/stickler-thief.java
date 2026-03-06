class Solution {
    
    int maxValue =Integer.MIN_VALUE;
    public int findMaxSum(int arr[]) {
        // code here
        // maxSum(arr,0,0);
        // return maxValue;
        
        int []dp = new int[arr.length+1];
        for(int i=0 ; i<=arr.length ;i++){
            dp[i] =-1; 
        }
        int n = arr.length-1;
        
        return memoization(arr,dp,n);
    }
    // public void maxSum(int arr[] , int sum, int idx){
    //     if(idx>=arr.length){
    //         maxValue = Math.max(maxValue,sum);
    //         return;
    //     }
        
    //     sum = sum+arr[idx];
    //     maxSum(arr,sum,idx+2);
    //     sum = sum-arr[idx];
    //     maxSum(arr, sum,idx+1);
    // }
    
    public int memoization(int arr[] , int []dp  , int idx){
         if(idx<0){
            return 0;
        }
        
         if(idx==0) return dp[idx] = arr[0];
         
        
        if(dp[idx]!=-1){
            return dp[idx];
        }
        

        int left = memoization(arr,dp,idx-2) + arr[idx];

        int right = memoization(arr,dp,idx-1);
        
         dp[idx] = Math.max(left,right);
         
        return dp[idx];
    }
}