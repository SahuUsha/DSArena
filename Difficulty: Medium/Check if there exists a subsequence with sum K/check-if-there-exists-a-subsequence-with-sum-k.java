// User function Template for Java

class Solution {
    public static boolean checkSubsequenceSum(int N, int[] arr, int k) {
        // code here
    //     int n = arr.length;
    //   return Subseq(arr,0,0,k,n);
    
    return subSequencewithDP(N,arr,k);
        
    }
    
//     public  static boolean Subseq(int[] arr,int idx, int sum , int k, int n){
        
//         if(sum==k){
//             return true;
//         }
//         if(idx>=n){
//             return false;
//         }
        
//         if(Subseq(arr,idx+1,sum+arr[idx],k,n)){
//             return true;
//         }
    
//         if(Subseq(arr,idx+1,sum,k,n)){
//             return true;
//         }
        
//         return false;
        
//     }

    
    public static boolean subSequencewithDP(int N , int []arr, int k){
        boolean [][]dp = new boolean[N+1][k+1];
        
        for(int i =0;i<=N;i++){
            dp[i][0] = true;
        }
        
        for(int i =1 ;i<=N;i++){
            for(int j=1 ; j<=k;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }
        
        return dp[N][k];
    }
    
}
