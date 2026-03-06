class Solution {
        int maxValue =Integer.MIN_VALUE;
    public int rob(int[] nums) {


        if(nums.length==1) return nums[0];
      

       int a1 =  tabulation1(nums);
       int a2 =  tabulation2(nums);
        return Math.max(a1,a2);
    }
    public int tabulation1(int[] arr){
        int []dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        
        for(int i = 2 ;i<arr.length-1;i++){
        
            int left = arr[i] + dp[i-2];
            int right = dp[i-1];
            
            dp[i] = Math.max(left,right);
        }

        
        return dp[arr.length-2];
    }

    public int tabulation2(int[] arr){
        int []dp = new int[arr.length];
        dp[1] = arr[1];
        
        for(int i = 2 ;i<arr.length;i++){
        
            int left  = arr[i] + dp[i-2];
            int right = dp[i-1];
            
            dp[i] = Math.max(left,right);
        }
        
        return dp[arr.length-1];
    }
}