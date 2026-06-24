class Solution {
    public int maxValue(int[] arr) {
        // code here
        
        if(arr.length==1) return arr[0];
        
        int t1 =  tabulation1(arr);
        int t2 =  tabulation2(arr);
        
        return Math.max(t1,t2);
        
    }
    
    public int tabulation1(int []arr){
        
        int dp[] = new int[arr.length];
        
        
         dp[0] = arr[0];
         dp[1] = Math.max(arr[0],arr[1]);
         
         
         for(int i = 2 ;i<arr.length ; i++){
             int left = arr[i];
             if(i-2>=0) left += dp[i-2];
             int right = dp[i-1];
             
             dp[i] = Math.max(left,right);
         }
         
         return dp[arr.length-2];
    }
    public int tabulation2(int []arr){
        
        int dp[] = new int[arr.length];
        
        
         dp[1] = arr[1];
         
         
         for(int i = 2 ;i<arr.length ; i++){
             int left = arr[i];
             if(i-2>=0) left += dp[i-2];
             int right = dp[i-1];
             
             dp[i] = Math.max(left,right);
         }
         
         return dp[arr.length-1];
    }
}
