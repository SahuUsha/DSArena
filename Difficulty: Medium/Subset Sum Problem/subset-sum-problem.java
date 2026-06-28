class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        
        
        int dp[][] = new int[arr.length][sum+1];
        for(int []d: dp){
            Arrays.fill(d,-1);
        }
        return isSubset(arr,sum,arr.length-1,dp);
    }
    static Boolean isSubset(int arr[], int target, int idx, int dp[][]){
        if(target==0 ){
            return true;
        }
        
         if(target<0 || idx<0){
            return false;
        }
        
        if(idx==0) return arr[idx]==target;
        
       
        if(dp[idx][target]!=-1){
            return dp[idx][target]==1;
        }
        
       boolean take =  isSubset(arr,target-arr[idx],idx-1,dp);
       boolean notTake =  isSubset(arr,target,idx-1,dp);
        
        dp[idx][target] = (take || notTake) ? 1:0;
        
        return dp[idx][target]==1;
         
        
    }
    
}