class Solution {
    int minCost(int[] height) {
        int n = height.length-1;
        // code here
        
        // return minJump(n,height);
        
        return memoization(height);
        
    }
    int minJump(int idx,int[] height){
        if(idx==0){
            return 0;
        }
        
        int right =Integer.MAX_VALUE;;
    
          int  left = minJump(idx-1,height) + Math.abs(height[idx]-height[idx-1]);
         
        if(idx>1){
         right = minJump(idx-2,height) + Math.abs(height[idx]-height[idx-2]);
            
        }
        
        return Math.min(left,right);
    }
    
    int memoization(int[] arr){
        int[] dp = new int[arr.length+1];
        
        dp[0] =0;
        
        for(int i=1;i<arr.length;i++){
            int left = dp[i-1] + Math.abs(arr[i]-arr[i-1]);
            
            int right = Integer.MAX_VALUE;
            if(i>1){
                right = dp[i-2] +Math.abs(arr[i]-arr[i-2]);
            }
            
            dp[i] = Math.min(left,right);
        }
        
        return dp[arr.length-1];
    }
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 