class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        
        // code here
        // int n = arr.length;
        // int [][]dp = new int[n][sum+1];
        // for(int []ar : dp){
        //     Arrays.fill(ar,-1);
        // }
        //  return isSubsetMemo(arr, n-1 ,sum, dp);
        
        // return isSubsetTablu(arr,sum);
        
        return spaceOptimize(arr,sum);
        
        
        
        
    }
    static Boolean isSubsetMemo(int arr[], int i ,int tar, int [][]dp){
        if(tar==0) return true;
        
        if(i<0) return false;
        
        
        if (i == 0) 
        return arr[0] == tar;
        
        if(dp[i][tar]!=-1) return dp[i][tar]==1;
      
        
        boolean take = false;
        
        if(tar>=arr[i]){
           take = isSubsetMemo(arr, i-1 ,tar-arr[i], dp);
        }
        
        boolean nottake = isSubsetMemo(arr, i-1 ,tar, dp);
        
        dp[i][tar] = (take || nottake) ? 1 : 0;
        
        return take || nottake;
        
    }
    
    static boolean isSubsetTablu(int arr[] , int tar){
        boolean [][]dp = new boolean[arr.length][tar+1];
        
      for(int i =0 ;i<arr.length;i++){
          dp[i][0] = true;
      }
      
      if(arr[0]<=tar){
      dp[0][arr[0]]= true;
          
      }
      
      for(int i = 1 ;i<arr.length ;i++){
          for(int target = 1 ; target<=tar;target++){
             
              boolean notTake = dp[i-1][target];
              
              boolean take = false;
              if(target>=arr[i]){
                  take = dp[i-1][target-arr[i]];
              }
              
              
              dp[i][target] = notTake || take;
              
          }
      }
      
      
      return  dp[arr.length-1][tar];
        
    }
    
    static boolean spaceOptimize(int []arr , int tar){
        boolean prev[] = new boolean[tar+1];
        
        
         if (arr[0] <= tar) {
        prev[arr[0]] = true;
    }
        prev[0] = true;
     
       
        
        for(int i = 1; i<arr.length ; i++){
             boolean curr[] = new boolean[tar + 1];
        curr[0] = true;
            for(int target = 1 ; target<=tar ; target++){
                boolean nottake = prev[target];
                boolean take = false;
                
                if(target>=arr[i]){
                    take = prev[target-arr[i]];
                }
                
                curr[target] = take || nottake;
            }
            prev = curr;
        }
        
        return prev[tar];
    
    }
    
    
}