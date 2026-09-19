class Solution {
    public int rob(int[] nums) {
        // return robb( nums, 0, 0);
        return robtab(nums);
        
    }

   
    public int robb(int []nums ,int sum, int idx){

        if(idx>=nums.length){
            return sum;
        }

        int notTake = robb(nums, sum , idx+1);
      
        int take = robb(nums, sum+nums[idx], idx+2);

     return Math.max(notTake,take);
    }

    public int robtab(int []nums){

        if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }

        int dp[]= new int[nums.length];
        dp[0] = nums[0];
         dp[1] = Math.max(nums[0], nums[1]);
        
     
        int last =0;



        for(int i = 2 ; i<nums.length ;i++){
            

                int notTake = dp[i-1];
                int take =0;
                if(i-2>=0){
                    take = dp[i-2]+ nums[i];
                }

                dp[i] = Math.max(notTake, take);
            }

        
     return dp[nums.length-1];
}
}