class Solution {
    // Function to calculate the number of subsets with a given sum
    int ans = 0;
    public int perfectSum(int[] nums, int target) {
        // code here
    //   return PerfectSum1(nums,target,0);
    
    return tabulation(nums,target);
        // return ans;
    }
    
    public int PerfectSum1(int []nums , int target, int idx){
         if (idx == nums.length) {
        return target == 0 ? 1 : 0;
      }
        
        int notTake =  PerfectSum1(nums, target, idx+1);
        
        int Take =0;
        if(nums[idx]<=target){
            
       Take =  PerfectSum1(nums,target-nums[idx],idx+1);
        }
        
        return notTake + Take; 
    }
    
    public int tabulation(int []nums, int target){
        int [][]dp = new int[nums.length+1][target+1];
        
        dp[0][0] =1;
        
        for(int i = 1 ; i<=nums.length ; i++){
            for(int tar = 0; tar<=target ;tar++){
                
                dp[i][tar] = dp[i-1][tar];
                
                if(nums[i-1]<=tar){
                    dp[i][tar] += dp[i-1][tar-nums[i-1]];
                    
                }
            }
        }
        
        return dp[nums.length][target];
    }
}