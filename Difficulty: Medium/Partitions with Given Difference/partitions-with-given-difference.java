class Solution {
    public int countPartitions(int[] arr, int diff) {
        // // code here
        int totalSum  = 0;
        for(int i  =0 ; i<arr.length ; i++){
            totalSum += arr[i];
        }
        
        
        // return CountPatter(arr,diff,0,0,totalSum);
        
        // int [][]dp = new int[arr.length][totalSum];
        
        // for(int []pd : dp){
        //     Arrays.fill(pd,-1);
        // }
        
        // return CountPatterMemo(arr,diff,0,0,totalSum,dp);
        
        return countPatterTabul(arr,diff,totalSum);
        
    }
    
    public int CountPatter(int []arr , int diff ,int idx, int sum, int totalSum){
        
        if(idx==arr.length){
            
        if((totalSum-sum)-sum==diff){
            return 1;
        }
        
        return 0;
        }
        
        
        int notTake = CountPatter(arr , diff, idx+1, sum, totalSum);
        
        int take = CountPatter(arr, diff, idx+1,sum+arr[idx], totalSum);
        
        
        
        return notTake + take;
    }
    
    
    public int CountPatterMemo(int []arr, int diff, int idx,int sum , int totalSum,int dp[][])
    {
        if(idx==arr.length){
            
        if((totalSum-sum)-sum==diff){
            return 1;
        }
        
        return 0;
        }
        
        if(dp[idx][sum]!=-1){
            return dp[idx][sum];
        }
        
        int notTake = CountPatter(arr , diff, idx+1, sum, totalSum);
        
        int take = CountPatter(arr, diff, idx+1,sum+arr[idx], totalSum);
        
        
        return notTake + take;
        
    }
    
    public int countPatterTabul(int[] arr, int diff, int totalSum) {

    // Invalid cases
    if ((totalSum - diff) < 0 || (totalSum - diff) % 2 != 0) {
        return 0;
    }

    int s2 = (totalSum - diff) / 2;

    int n = arr.length;

    int[][] dp = new int[n][s2 + 1];

    // Base case
    // Sum 0 can always be formed
    for (int i = 0; i < n; i++) {
        dp[i][0] = 1;
    }

    // First element
    if(arr[0]==0){
        dp[0][0] = 2;
    }else{
        dp[0][0] =1;
    }
    
    if (arr[0] != 0 && arr[0] <= s2) {
        dp[0][arr[0]] = 1;
    }

    for (int i = 1; i < n; i++) {

        for (int sum = 0; sum <= s2; sum++) {

            int notTake = dp[i - 1][sum];

            int take = 0;

            // Correct condition
            if (arr[i] <= sum) {
                take = dp[i - 1][sum - arr[i]];
            }

            dp[i][sum] = take + notTake;
        }
    }
    return dp[n - 1][s2];
}
    
}
