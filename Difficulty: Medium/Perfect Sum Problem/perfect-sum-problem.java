class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        
        
        // int dp[][] = new int[nums.length][target+1];
        
        
        // for(int[] pd : dp){
            
        // Arrays.fill(pd,-1);
        // }
        
        // return ksubset2(nums,target,0,dp);
        
        return tabulation(nums,target);
        
        
    }
    
    // public int ksubset(int[] nums , int target ,int sum, int idx){
        
        
    //     if (idx == nums.length) {

    //     if (sum == target) {
    //         return 1;
    //     }
    //     return 0;
    // }

        
    //     int notake = ksubset(nums,target,sum,idx+1);
        
    //     int take = ksubset(nums,target,sum + nums[idx], idx+1);
        
    //     return notake + take;
    // }
     public int ksubset(int[] nums , int target ,int sum, int idx){
        
        
        if (idx == nums.length) {

        if (sum == target) {
            return 1;
        }
        return 0;
    }

        
        int notake = ksubset(nums,target,sum,idx+1);
        
        int take = ksubset(nums,target,sum + nums[idx], idx+1);
        
        return notake + take;
    }
    
    
    public int ksubset2(int[] nums , int target ,int idx, int [][]dp){
        
        if (idx == nums.length) {
        
        if (target==0) {
            return 1;
        }
        return 0;
        }

        if(dp[idx][target]!=-1){
            return dp[idx][target];
        }
        
        int notake = ksubset2(nums,target,idx+1,dp);
        
        int take = 0;
        if(target>=nums[idx]){
            
        take = ksubset2(nums,target-nums[idx], idx+1,dp);
        }
        
        
        dp[idx][target] = notake + take;
        
        return dp[idx][target];
    }
    
    public int tabulation(int []nums,int target){
        
        int [][]dp = new int[nums.length][target+1];
        
        
        if(nums[0]==0){
            dp[0][0] = 2;
        }else{
            dp[0][0] =1;
        }
        
        
        if(nums[0] != 0 && nums[0]<=target){
            dp[0][nums[0]] = 1;
        }
        
        // for(int i = 0 ; i<nums.length;i++){
        //     dp[i][0] = 1;
        // }
        
        for(int i = 1 ;i<nums.length ;i++){
            for(int tar = 0 ; tar<=target;tar++){
                int notTake = dp[i-1][tar];
                
                int take =0;
                
                if(nums[i]<=tar){
                    take = dp[i-1][tar-nums[i]];
                }
                
                dp[i][tar] = notTake+take;
            }
        }
        return dp[nums.length-1][target];
    }
    
}