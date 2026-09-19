class Solution {
    public int maxValue(int[] arr) {
        // code here
        int takeZero =  thief2D(arr, 0,arr.length-2);
        int notTakeZero = thief2D(arr, 1,arr.length-1);
        
        return Math.max(takeZero, notTakeZero);
    
        
    }
    
    public int thief2D(int []arr, int start , int end){
        
        if(arr.length==1){
            return arr[0];
        }else if(arr.length==2){
            return Math.max(arr[0],arr[1]); 
        }
        
        int []dp = new int[arr.length];
        
        dp[start] = arr[start];
        
        if(start+1<=end){
            dp[start+1] = Math.max(arr[start+1],arr[start]);
        }
        
        for(int i = start+2 ; i<=end;i++){
            
            int notTake = dp[i-1];
            
            int take = dp[i-2] + arr[i];
            
            
            dp[i] = Math.max(take, notTake);
        }
        
        return dp[end];
    }
    
}
