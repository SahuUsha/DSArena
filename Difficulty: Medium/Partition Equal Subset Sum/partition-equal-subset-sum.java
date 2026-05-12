class Solution {
    static boolean equalPartition(int arr[]) {
        // code here
        
        
      int totalSum = 0;
      for(int i = 0 ; i<arr.length ;i++){
          totalSum += arr[i];
      }
      
      if(totalSum%2!=0){
          return false;
      }
      
      int target = totalSum/2;
      
      
      
      boolean dp[] = new boolean[target+1];
      dp[0] = true;
      
      for(int num : arr){
          for(int i = target; i>=num ;i--){
              dp[i] = dp[i] || dp[i-num];
          }
      }
      
      return dp[target];
    }
}