class Solution {
    static int lis(int arr[]) {
        
        int dp[][] = new int[arr.length][arr.length+1];
        for(int[]d : dp){
        Arrays.fill(d,-1);
        }
        // code here
        return longestRecur(0,-1,arr,dp);
    }
    
    int max = Integer.MIN_VALUE;
    
    public static int longestRecur(int idx, int prevIdx , int []arr, int dp[][]){
         if(idx==arr.length ){
            //  max = Math.max(len);
             return 0;
         }
         
         if(dp[idx][prevIdx+1]!=-1){
             return dp[idx][prevIdx+1];
         }
         
         int take = 0;
         
         if(prevIdx==-1 || arr[idx]>arr[prevIdx]){
            take = 1+longestRecur(idx+1,idx,arr,dp);
         }
         
         int notTake = longestRecur(idx+1,prevIdx,arr,dp);
         
         dp[idx][prevIdx+1] = Math.max(take,notTake);
        
         return dp[idx][prevIdx+1];
    }
    
    
}