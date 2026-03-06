class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length-1;

        return sloveOptimization(nums) ;

    }

    public int solveRec(int []nums , int n){

        if(n<0){
            return 0;
        }
        if(n==0){
            return nums[0];
        }

        int include = solveRec(nums , n-2) + nums[n];
        int exclude = solveRec(nums , n-1) + 0;

        return Math.max(include , exclude);
    }

    public int solveMemo(int []nums , int n , int []dp){
      
      if(n<0){
            return 0;
        }
        if(n==0){
            return nums[0];
        }

        if(dp[n]== -1){
            return dp[n];
        }

         int include = solveRec(nums , n-2) + nums[n];
        int exclude = solveRec(nums , n-1) + 0;

        dp[n] = Math.max(include , exclude);

        return dp[n];
    }

    public int sloveTab(int []nums ){
      int n = nums.length;
     if (n == 0) return 0;
    if (n == 1) return nums[0];

    int[] dp = new int[n];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);


      for(int i =2; i<n;i++){
         int include = dp[i-2] + nums[i];
         int exclude = dp[i-1] + 0;

         dp[i] = Math.max(include , exclude);
      }

      return dp[n-1];  
    }


//   SC =O(1)
     public int sloveOptimization(int []nums ){
      int n = nums.length;

      int prev2 = 0;
      int prev1 = nums[0];
    
      for(int i =1; i<n;i++){
         int include = prev2 + nums[i];
         int exclude = prev1+ 0;

         int ans = Math.max(include , exclude);
         prev2 = prev1;
         prev1 = ans;
      }

      return prev1;  
    }
    
}