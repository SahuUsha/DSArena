class Solution {
    public int minDifference(int arr[]) {
        // code here
        int totalSum = 0 ;
        for(int i = 0 ; i<arr.length ; i++){
            totalSum +=arr[i];
        }
        
        return tabulation(arr,totalSum);
        
    }
    
    int min = Integer.MAX_VALUE;
    public int twoSubset(int arr[], int total, int sum , int idx){
        if(idx==0){
            min    = Math.min(min , Math.abs((total-sum)-sum));
            return min;
        }
        
        int take1 = twoSubset(arr, total,sum+arr[idx], idx-1);
        
        int take2 = twoSubset(arr,total,sum,idx-1);
        
        
        return Math.min(take1,take2);
        
    }
    
    public int tabulation(int []arr,int totalSum){
        
        boolean dp[][] = new boolean[arr.length][totalSum+1];
        
        for(int i = 0 ;  i <arr.length ; i++){
            dp[i][0] = true;
        }
       
      if(arr[0]<totalSum){
          dp[0][arr[0]] = true;
      }
      
      for(int i =1 ; i<arr.length;i++){                    
          for(int tar = 1 ; tar<=totalSum ; tar++){
              boolean notTake = dp[i-1][tar];
              boolean take = false;
              if(arr[i]<=tar){
                  take = dp[i-1][tar-arr[i]];
              }
              
              dp[i][tar] =  notTake || take;
          }
      }
       
       
       int diff = Integer.MAX_VALUE;
       for(int i =0; i<=totalSum ; i++){
           if(dp[arr.length-1][i]){diff = Math.min(diff, Math.abs((totalSum - i) - i));}
       }
       
       return diff;
    }
}
