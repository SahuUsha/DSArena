class Solution {
    
    public int countPartitions(int[] arr, int diff) {
        // code here
        int totalSum = 0;
        for(int i =0 ;i<arr.length;i++){
            totalSum += arr[i];
        }
        
        // return Partition(arr,diff,totalSum,0,0);
        
        // int dp[][] = new int[arr.length][totalSum];
        // for(int []d : dp){
        //     Arrays.fill(d,-1);
        // }
        // return memoization(arr,diff,totalSum,dp,0,0);
        
        return tabulation(arr,diff,totalSum);
    }
    
    public int Partition(int []arr , int diff, int totalSum, int idx, int s1){
        
        if (idx == arr.length) {
       return (s1 - (totalSum - s1) == diff) ? 1 : 0;
        }
        
        int NotTake = Partition(arr,diff,totalSum,idx+1 ,s1);
        
        int take = Partition(arr,diff,totalSum,idx+1,s1+arr[idx]);
        
        return NotTake+take;
    }
    
    public int memoization(int []arr , int diff, int totalSum, int dp[][],int idx, int s1 ){
        
        
        if(idx==arr.length){
            return (s1 - (totalSum - s1) == diff) ? 1 : 0;
        }
        
        if(dp[idx][s1]!=-1){
            return dp[idx][s1];
        }
        
       int NotTake = Partition(arr,diff,totalSum,idx+1 ,s1);
       
       int take = Partition(arr,diff,totalSum,idx+1,s1+arr[idx]);
       
       dp[idx][s1] = NotTake+take;
       return dp[idx][s1];
    }
    
    public int tabulation(int []arr, int diff,int totalSum){
        int [][]dp = new int[arr.length+1][totalSum+1];
        
        int n = arr.length;
        
        for(int s1 =0 ; s1<=totalSum; s1++){
            if(s1 - (totalSum - s1) == diff){
            dp[n][s1] = 1;
            }
        }
        
        for(int i = arr.length-1 ;i>=0;i--){
            for(int s1 = totalSum ; s1>=0 ;s1--){
                int take = 0;
                
                if(s1+arr[i]<=totalSum){
                 take = dp[i+1][s1+arr[i]];
                }
                
                dp[i][s1] = dp[i+1][s1]+take;
            }
        }
        
        return dp[0][0];
    }
}
